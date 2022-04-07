package pl.adamd.crmsrv.offer.service.material;

import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;

import java.util.List;

public interface MaterialViewService {
    List<MaterialViewResponse> getAllMaterials();
}
