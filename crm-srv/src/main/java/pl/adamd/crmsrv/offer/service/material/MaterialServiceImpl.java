package pl.adamd.crmsrv.offer.service.material;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.client.repository.ClientRepository;
import pl.adamd.crmsrv.offer.entity.Material;
import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;
import pl.adamd.crmsrv.offer.repository.MaterialRepository;
import pl.adamd.crmsrv.offer.repository.MaterialsToOfferRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;
    private final MaterialsToOfferRepository materialsToOfferRepository;

    @Override
    public Material findById(Long id) {
        if (!materialRepository.existsById(id)) {
            throw new RuntimeException("The specified material does not exist");
        }
        return materialRepository.getById(id);
    }

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material save(Material material) {
        return materialRepository.save(material);
    }



}
