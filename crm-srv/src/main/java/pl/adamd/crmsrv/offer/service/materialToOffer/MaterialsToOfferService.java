package pl.adamd.crmsrv.offer.service.materialToOffer;

import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;

import java.util.List;

public interface MaterialsToOfferService {

    MaterialsToOffer save(MaterialsToOffer materials);

    List<MaterialsToOffer> findAll();
}
