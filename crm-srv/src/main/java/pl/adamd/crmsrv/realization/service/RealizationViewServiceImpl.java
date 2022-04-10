package pl.adamd.crmsrv.realization.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.adamd.crmsrv.agreement.dto.AgreementViewResponse;
import pl.adamd.crmsrv.agreement.entity.Agreement;
import pl.adamd.crmsrv.agreement.mapper.AgreementMapper;
import pl.adamd.crmsrv.agreement.service.AgreementService;
import pl.adamd.crmsrv.client.dto.response.AddressViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientAddressesViewResponse;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.client.mapper.ClientMapper;
import pl.adamd.crmsrv.common.MaterialsFlag;
import pl.adamd.crmsrv.device.dto.DeviceOrderViewResponse;
import pl.adamd.crmsrv.device.dto.DeviceViewResponse;
import pl.adamd.crmsrv.device.entity.Device;
import pl.adamd.crmsrv.device.mapper.DeviceMapper;
import pl.adamd.crmsrv.device.service.DeviceService;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.dto.material.MaterialListOfferResponse;
import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;
import pl.adamd.crmsrv.offer.entity.Installation;
import pl.adamd.crmsrv.offer.entity.Material;
import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;
import pl.adamd.crmsrv.offer.entity.Offer;
import pl.adamd.crmsrv.offer.mapper.InstallationMapper;
import pl.adamd.crmsrv.offer.mapper.MaterialMapper;
import pl.adamd.crmsrv.offer.mapper.MaterialsToOfferMapper;
import pl.adamd.crmsrv.offer.service.materialToOffer.MaterialsToOfferService;
import pl.adamd.crmsrv.offer.service.offer.OfferService;
import pl.adamd.crmsrv.realization.dto.RealizationViewRequest;
import pl.adamd.crmsrv.realization.dto.RealizationViewResponse;
import pl.adamd.crmsrv.realization.enitity.Realization;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.math.BigInteger.ZERO;

@Service
@AllArgsConstructor
public class RealizationViewServiceImpl implements RealizationViewService {
    private final RealizationService realizationService;
    private final OfferService offerService;
    private final DeviceService deviceService;
    private final AgreementService agreementService;
    private final MaterialsToOfferService materialsToOfferService;
    private final DeviceMapper deviceMapper;
    private final ClientMapper clientMapper;
    private final AgreementMapper agreementMapper;
    private final MaterialMapper materialMapper;
    private final InstallationMapper installationMapper;
    private final MaterialsToOfferMapper toOfferMapper;


    @Override
    @Transactional
    public RealizationViewResponse createNewRealization(RealizationViewRequest request) {
        Offer offer = offerService.findById(request.getOfferId());

        List<MaterialsToOffer> materials = getMaterialList(offer);

        Realization realization = getRealization(offer, materials);

        setRealizationToSpecifyMaterial(realization);

        specifyDevicesToRealization(materials, realization);


        BigDecimal netPriceMaterials = new BigDecimal(ZERO);
        BigDecimal grossPriceMaterials = new BigDecimal(ZERO);

        for (MaterialsToOffer material : materials) {
            netPriceMaterials = netPriceMaterials.add(material.getMaterial().getPrice());
            BigDecimal materialGrossPrice = material.getMaterial().getGrossPrice();
            grossPriceMaterials = grossPriceMaterials.add(materialGrossPrice);
        }

        BigDecimal netPriceInstallations = new BigDecimal(ZERO);
        BigDecimal grossPriceInstallations = new BigDecimal(ZERO);

        for (Installation installation : offer.getInstallationList()) {
            netPriceInstallations = netPriceInstallations.add(installation.getPrice());
            BigDecimal installationGrossPrice = installation.getGrossPrice();
            grossPriceInstallations = grossPriceInstallations.add(installationGrossPrice);
        }

        BigDecimal totalNetPrice = netPriceMaterials.add(netPriceInstallations);
        BigDecimal totalGrossPrice = grossPriceMaterials.add(grossPriceInstallations);

        Agreement agreement = getAgreement(request, offer, realization, totalNetPrice, totalGrossPrice);

        updateClient(realization, agreement);


        return getRealizationViewResponse(realization);
    }

    private void specifyDevicesToRealization(List<MaterialsToOffer> materials, Realization realization) {
        for (MaterialsToOffer material : materials) {
            List<Device> devices = new ArrayList<>();

            if (material.getMaterial().getMaterialsFlag().equals(MaterialsFlag.device)) {
                Device device = deviceService.findAll().stream()
                        .filter(
                                dev -> dev.getName().equals(material.getMaterial().getName()) &&
                                        dev.getProducer().equals(material.getMaterial().getProducer()) &&
                                        dev.getPower().equals(material.getMaterial().getPower()) &&
                                        dev.getCategory().equals(material.getMaterial().getCategory()) &&
                                        dev.getPrice().equals(material.getMaterial().getPrice()) &&
                                        !dev.isSold()).findFirst().get();
                devices.add(device);
                device.setSold(true);
                device.setRealization(realization);
            }
            realization.setSpecifyDevice(devices);
        }
    }

    private void setRealizationToSpecifyMaterial(Realization realization) {
        for (MaterialsToOffer materialsToOffer : realization.getMaterials()) {
            materialsToOffer.setRealization(realization);
            materialsToOfferService.save(materialsToOffer);
        }
    }

    private RealizationViewResponse getRealizationViewResponse(Realization realization) {

        Client client = realization.getClient();
        ClientAddressesViewResponse clientResponse = getClientAddressesViewResponse(client);

        List<MaterialListOfferResponse> materialListOfferResponseList =
                toOfferMapper.mapOfferListToDto(realization.getOffer().getMaterials());

        AgreementViewResponse agreementResponse =
                agreementMapper.mapAgreementToDto(realization.getAgreement());

        List<InstallationViewResponse> installationResponseList =
                installationMapper.installationListToDto(realization.getOffer().getInstallationList());

        RealizationViewResponse response = new RealizationViewResponse();
        response.setClientDetails(clientResponse);
        response.setAgreementDetails(agreementResponse);
        response.setMaterialsList(materialListOfferResponseList);
        response.setInstallationsDetails(installationResponseList);
        return response;
    }

    private List<MaterialsToOffer> getMaterialList(Offer offer) {
        return new ArrayList<>(offer.getMaterials());
    }

    private ClientAddressesViewResponse getClientAddressesViewResponse(Client client) {
        ClientAddressesViewResponse clientResponse = new ClientAddressesViewResponse();
        List<AddressViewResponse> clientsAddresses = clientMapper.mapAddressesListToDto(client.getAddresses());
        clientResponse.setClient(clientMapper.mapClientToDto(client));
        clientResponse.setAddresses(clientsAddresses);
        return clientResponse;
    }

    private Client updateClient(Realization realization, Agreement agreement) {

        Client client = agreement.getClient();
        client.getAgreements().add(agreement);
        client.getRealizations().add(realization);
        client.setInstallation(true);
        client.setAgreement(true);
        return client;
    }

    private Agreement getAgreement(RealizationViewRequest request,
                                   Offer offer,
                                   Realization realization,
                                   BigDecimal netPrice,
                                   BigDecimal grossPrice
    ) {
        List<Realization> realizations = new ArrayList<>();
        realizations.add(realization);

        if (agreementService.findByAgreementNumber(request.getNewAgreementNumber())) {
            throw new RuntimeException("Umowa o podanym numerze już istenieje");
        }

        Agreement agreement = Agreement.builder()
                .agreementNumber(request.getNewAgreementNumber())
                .client(offer.getClient())
                .netContractAmount(netPrice.setScale(2, RoundingMode.HALF_DOWN))
                .grossContractAmount(grossPrice.setScale(2, RoundingMode.HALF_DOWN))
                .realizations(realizations)
                .dateOfSigning(request.getDateOfSigning())
                .build();

        agreementService.save(agreement);

        realization.setAgreement(agreement);
        return agreement;
    }

    private Realization getRealization(Offer offer, List<MaterialsToOffer> materials) {
        Realization realization = Realization.builder()
                .offer(offer)
                .materials(materials)
                .client(offer.getClient())
                .inProgress(true)
                .done(false)
                .build();

        realizationService.save(realization);
        return realization;
    }


}
