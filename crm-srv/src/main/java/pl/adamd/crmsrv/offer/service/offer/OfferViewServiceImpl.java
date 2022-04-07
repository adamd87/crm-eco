package pl.adamd.crmsrv.offer.service.offer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.client.service.ClientService;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;
import pl.adamd.crmsrv.offer.dto.offer.OfferViewRequest;
import pl.adamd.crmsrv.offer.dto.offer.OfferViewResponse;
import pl.adamd.crmsrv.offer.entity.Installation;
import pl.adamd.crmsrv.offer.entity.Material;
import pl.adamd.crmsrv.offer.entity.Offer;
import pl.adamd.crmsrv.offer.mapper.InstallationMapper;
import pl.adamd.crmsrv.offer.mapper.MaterialMapper;
import pl.adamd.crmsrv.offer.service.installation.InstallationService;
import pl.adamd.crmsrv.offer.service.material.MaterialService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OfferViewServiceImpl implements OfferViewService {
    private final OfferService offerService;
    private final ClientService clientService;
    private final MaterialService materialService;
    private final InstallationService installationService;
    private final InstallationMapper installationMapper;
    private final MaterialMapper materialMapper;

    @Override
    public List<OfferViewResponse> getAllOffers() {
        List<Offer> offerList = offerService.findAllOffers();

        return getOfferViewResponseList(offerList);
    }

    @Override
    public List<OfferViewResponse> getOffersByClient(Long clientId) {
        List<Offer> offerListByClientId = offerService.findByClientId(clientId);

        return getOfferViewResponseList(offerListByClientId);
    }

    @Override
    public OfferViewResponse getOffersById(Long offerId) {
        Offer offer = offerService.findById(offerId);

        return getOfferViewResponse(offer);
    }

    @Override
    @Transactional
    public OfferViewResponse createNewOffer(OfferViewRequest offerViewRequest) {

        Client client = clientService.findClientById(offerViewRequest.getClientId());

        List<Material> materialList = getDeviceList(offerViewRequest);
        BigDecimal devicesPrice = getDevicesPrice(materialList);

        List<Installation> installationList = getInstallationList(offerViewRequest);
        BigDecimal installationPrice = getInstallationPrice(installationList);

        BigDecimal totalPrice = devicesPrice.add(installationPrice).setScale(2, RoundingMode.HALF_DOWN);

        long executionTimeInDays = getExecutionTimeInDays(installationList);

        LocalDate estimatedCompletionDate = offerViewRequest.getNearestStartDate().plusDays(executionTimeInDays);

        Offer offer = Offer.builder()
                .client(client)
                .materials(materialList)
                .installationList(installationList)
                .totalPrice(totalPrice)
                .dayOfStart(offerViewRequest.getNearestStartDate())
                .dayOfEnd(estimatedCompletionDate)
                .build();

        offerService.save(offer);

        return getOfferViewResponse(offer);
    }

    private long getExecutionTimeInDays(List<Installation> installationList) {
        long executionTimeInDays = 0;
        for (Installation installation : installationList) {
            executionTimeInDays = executionTimeInDays + installation.getExecutionTimeInDays();
        }
        return executionTimeInDays;
    }

    private BigDecimal getInstallationPrice(List<Installation> installationList) {
        BigDecimal installationPrice = new BigDecimal(BigInteger.ZERO);
        for (Installation installation : installationList) {
            installationPrice = installationPrice.add(installation.getPrice());
        }
        return installationPrice;
    }

    private BigDecimal getDevicesPrice(List<Material> materialList) {
        BigDecimal materialsPrice = new BigDecimal(BigInteger.ZERO);
        for (Material material : materialList) {
            materialsPrice = materialsPrice.add(material.getPrice());
        }
        return materialsPrice;
    }

    private List<Installation> getInstallationList(OfferViewRequest offerViewRequest) {
        List<Installation> installationList = new ArrayList<>();
        for (Long installationId : offerViewRequest.getInstallationIdList()) {
            Installation installation = installationService.findInstallationById(installationId);
            installationList.add(installation);
        }
        return installationList;
    }

    private List<Material> getDeviceList(OfferViewRequest offerViewRequest) {
        List<Material> deviceList = new ArrayList<>();
        for (Long materialId : offerViewRequest.getMaterialIdList()) {
            Material material = materialService.findById(materialId);
            deviceList.add(material);
        }
        return deviceList;
    }

    private List<OfferViewResponse> getOfferViewResponseList(List<Offer> offerList) {
        List<OfferViewResponse> offerViewResponseList = new ArrayList<>();

        for (Offer offer : offerList) {
            OfferViewResponse offerViewResponse = getOfferViewResponse(offer);
            offerViewResponseList.add(offerViewResponse);
        }
        return offerViewResponseList;
    }

    private OfferViewResponse getOfferViewResponse(Offer offer) {
        OfferViewResponse offerViewResponse = new OfferViewResponse();
        List<MaterialViewResponse> materialViewResponsesList = materialMapper.mapMaterialListToDto(offer.getMaterials());
        List<InstallationViewResponse> installationViewResponseList = installationMapper.installationListToDto(offer.getInstallationList());
        offerViewResponse.setMaterialList(materialViewResponsesList);
        offerViewResponse.setInstallationList(installationViewResponseList);
        offerViewResponse.setClientId(offer.getClient().getId());
        offerViewResponse.setClientFullName(offer.getClient().getName() + " " + offer.getClient().getSurname());
        offerViewResponse.setTotalPrice(offer.getTotalPrice());
        offerViewResponse.setApproximateStartDate(offer.getDayOfStart());
        offerViewResponse.setApproximateEndDate(offer.getDayOfEnd());
        return offerViewResponse;
    }
}
