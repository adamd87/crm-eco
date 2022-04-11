package pl.adamd.crmsrv.offer.service.material;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.common.MaterialsFlag;
import pl.adamd.crmsrv.offer.dto.material.request.MaterialCreateRequest;
import pl.adamd.crmsrv.offer.dto.material.request.MaterialUpdateRequest;
import pl.adamd.crmsrv.offer.dto.material.response.MaterialViewResponse;
import pl.adamd.crmsrv.offer.dto.material.response.MaterialsListViewResponse;
import pl.adamd.crmsrv.offer.entity.Material;
import pl.adamd.crmsrv.offer.mapper.MaterialMapper;

import java.util.List;

import static pl.adamd.crmsrv.common.CommonUtils.setIfNotNull;

@Service
@AllArgsConstructor
public class MaterialViewServiceImpl implements MaterialViewService {
    private final MaterialService materialService;
    private final MaterialMapper materialMapper;

    @Override
    public List<MaterialsListViewResponse> getAllMaterials() {
        return materialMapper.mapMaterialsListToDto(materialService.findAll());
    }

    @Override
    public MaterialViewResponse addNewMaterial(MaterialCreateRequest materialCreateRequest) {
        Material material = materialMapper.mapDtoToMaterial(materialCreateRequest);
        material.setMaterialsFlag(MaterialsFlag.materials);
        materialService.save(material);
        return materialMapper.mapMaterialToDto(material);
    }

    @Override
    public MaterialViewResponse updateMaterial(Long materialId, MaterialUpdateRequest updateRequest) {
        Material material = materialService.findById(materialId);

        setIfNotNull(updateRequest.getName(), material::setName);
        setIfNotNull(updateRequest.getProducer(), material::setProducer);
        setIfNotNull(updateRequest.getPower(), material::setPower);
        setIfNotNull(updateRequest.getCategory(), material::setCategory);
        setIfNotNull(updateRequest.getPrice(), material::setPrice);
        setIfNotNull(updateRequest.getUnit(), material::setUnit);
        materialService.save(material);

        return materialMapper.mapMaterialToDto(material);
    }

//    @Override
//    public MaterialViewResponse increaseMaterialCount(Long materialId, MaterialIncreaseCountRequest request) {
//        Material material = materialService.findById(materialId);
//
    //todo: count z Obiektu material został tymczasowo usunięty

//        material.setCount(material.getCount().add(request.getIncreaseBy()));
//        materialService.save(material);
//        return materialMapper.mapMaterialToDto(material);
//    }
}
