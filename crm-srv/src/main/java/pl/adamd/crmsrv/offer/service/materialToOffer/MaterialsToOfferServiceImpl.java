package pl.adamd.crmsrv.offer.service.materialToOffer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;
import pl.adamd.crmsrv.offer.repository.MaterialsToOfferRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialsToOfferServiceImpl implements MaterialsToOfferService{
    private final MaterialsToOfferRepository materialsToOfferRepository;

    @Override
    public MaterialsToOffer save(MaterialsToOffer materials) {
        return materialsToOfferRepository.save(materials);
    }

    @Override
    public List<MaterialsToOffer> findAll() {
        return materialsToOfferRepository.findAll();
    }
}
