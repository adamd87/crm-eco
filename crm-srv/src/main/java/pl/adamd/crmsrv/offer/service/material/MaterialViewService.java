package pl.adamd.crmsrv.offer.service.material;

import pl.adamd.crmsrv.offer.dto.material.*;

import java.util.List;

public interface MaterialViewService {
    List<MaterialsListViewResponse> getAllMaterials();

    MaterialViewResponse addNewMaterial(MaterialCreateRequest materialCreateRequest);

    MaterialViewResponse updateMaterial(Long materialId, MaterialUpdateRequest materialCreateRequest);

    MaterialViewResponse increaseMaterialCount(Long materialId, MaterialIncreaseCountRequest request);
}
