package pl.adamd.crmsrv.offer.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.adamd.crmsrv.offer.dto.material.MaterialCreateRequest;
import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;
import pl.adamd.crmsrv.offer.dto.material.MaterialsListViewResponse;
import pl.adamd.crmsrv.offer.entity.Material;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MaterialMapper {

    List<Material> mapDtoListToMaterial(List<MaterialViewResponse> materialViewResponse);

    List<MaterialViewResponse> mapMaterialListToDto(List<Material> materials);

    List<MaterialsListViewResponse> mapMaterialsListToDto(List<Material> materials);

    Material mapDtoToMaterial(MaterialViewResponse materialViewResponse);

    Material mapDtoToMaterial(MaterialCreateRequest materialViewResponse);

    MaterialViewResponse mapMaterialToDto(Material material);


}
