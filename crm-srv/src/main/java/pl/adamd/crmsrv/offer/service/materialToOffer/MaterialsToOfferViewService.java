package pl.adamd.crmsrv.offer.service.materialToOffer;

import pl.adamd.crmsrv.offer.dto.material.MaterialListOfferResponse;

import java.util.List;

public interface MaterialsToOfferViewService {
    List<MaterialListOfferResponse> findAll();
}
