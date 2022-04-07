package pl.adamd.crmsrv.offer.service.offer;


import pl.adamd.crmsrv.offer.entity.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> findAllOffers();

    List<Offer> findByClientId(Long id);

    Offer findById(Long id);

    Offer save(Offer offer);

}
