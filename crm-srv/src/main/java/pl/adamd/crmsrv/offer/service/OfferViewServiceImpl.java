package pl.adamd.crmsrv.offer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.device.dto.DeviceViewResponse;
import pl.adamd.crmsrv.device.mapper.DeviceMapper;
import pl.adamd.crmsrv.offer.dto.InstallationViewResponse;
import pl.adamd.crmsrv.offer.dto.OfferViewResponse;
import pl.adamd.crmsrv.offer.entity.Offer;
import pl.adamd.crmsrv.offer.mapper.InstallationMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OfferViewServiceImpl implements OfferViewService {
    private final OfferService offerService;
    private final InstallationMapper installationMapper;
    private final DeviceMapper deviceMapper;

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
        List<DeviceViewResponse> deviceViewResponseList = deviceMapper.mapListDevicesToDto(offer.getDevices());
        List<InstallationViewResponse> installationViewResponseList = installationMapper.installationListToDto(offer.getInstallationList());
        offerViewResponse.setDeviceList(deviceViewResponseList);
        offerViewResponse.setInstallationList(installationViewResponseList);
        offerViewResponse.setClientId(offer.getClient().getId());
        offerViewResponse.setClientFullName(offer.getClient().getName() + " " + offer.getClient().getSurname());
        offerViewResponse.setTotalPrice(offer.getTotalPrice());
        offerViewResponse.setApproximateStartDate(offer.getDayOfStart());
        offerViewResponse.setApproximateEndDate(offer.getDayOfEnd());
        return offerViewResponse;
    }
}
