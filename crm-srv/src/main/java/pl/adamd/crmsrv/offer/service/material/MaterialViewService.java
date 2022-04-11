package pl.adamd.crmsrv.offer.service.material;

import pl.adamd.crmsrv.offer.dto.material.request.MaterialCreateRequest;
import pl.adamd.crmsrv.offer.dto.material.request.MaterialUpdateRequest;
import pl.adamd.crmsrv.offer.dto.material.response.MaterialViewResponse;
import pl.adamd.crmsrv.offer.dto.material.response.MaterialsListViewResponse;

import java.util.List;

public interface MaterialViewService {
    List<MaterialsListViewResponse> getAllMaterials();

    MaterialViewResponse addNewMaterial(MaterialCreateRequest materialCreateRequest);

    MaterialViewResponse updateMaterial(Long materialId, MaterialUpdateRequest materialCreateRequest);

//    MaterialViewResponse increaseMaterialCount(Long materialId, MaterialIncreaseCountRequest request);
}
