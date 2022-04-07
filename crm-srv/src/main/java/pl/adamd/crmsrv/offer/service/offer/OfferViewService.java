package pl.adamd.crmsrv.offer.service.offer;

import pl.adamd.crmsrv.offer.dto.offer.OfferViewRequest;
import pl.adamd.crmsrv.offer.dto.offer.OfferViewResponse;

import java.util.List;

public interface OfferViewService {
    List<OfferViewResponse> getAllOffers();

    List<OfferViewResponse> getOffersByClient(Long clientId);

    OfferViewResponse getOffersById(Long offerId);

    OfferViewResponse createNewOffer(OfferViewRequest offerViewRequest);
}
