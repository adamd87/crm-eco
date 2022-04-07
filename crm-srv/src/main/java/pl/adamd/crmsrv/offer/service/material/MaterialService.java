package pl.adamd.crmsrv.offer.service.material;

import pl.adamd.crmsrv.offer.entity.Material;

import java.util.List;

public interface MaterialService {
    Material findById(Long id);

    List<Material> findAll();

    Material save(Material material);
}
