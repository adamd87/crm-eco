package pl.adamd.crmsrv.offer.service.material;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;
import pl.adamd.crmsrv.offer.mapper.MaterialMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialViewServiceImpl implements MaterialViewService {
    private final MaterialService materialService;
    private final MaterialMapper materialMapper;

    @Override
    public List<MaterialViewResponse> getAllMaterials() {
        return materialMapper.mapMaterialListToDto(materialService.findAll());
    }
}
