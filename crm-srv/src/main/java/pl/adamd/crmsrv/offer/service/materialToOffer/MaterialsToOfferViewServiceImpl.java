package pl.adamd.crmsrv.offer.service.materialToOffer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.offer.dto.material.response.MaterialListOfferResponse;
import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;
import pl.adamd.crmsrv.offer.mapper.MaterialsToOfferMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialsToOfferViewServiceImpl implements MaterialsToOfferViewService{
    private final MaterialsToOfferService materialsToOfferService;
    private final MaterialsToOfferMapper materialsToOfferMapper;

    @Override
    public List<MaterialListOfferResponse> findAll() {
        List<MaterialsToOffer> materials = materialsToOfferService.findAll();
        return materialsToOfferMapper.mapOfferListToDto(materials);
    }
}
