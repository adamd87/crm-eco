package pl.adamd.crmsrv.offer.service;

import pl.adamd.crmsrv.offer.dto.OfferViewResponse;

import java.util.List;

public interface OfferViewService {
    List<OfferViewResponse> getAllOffers();

    List<OfferViewResponse> getOffersByClient(Long clientId);

    OfferViewResponse getOffersById(Long offerId);
}
