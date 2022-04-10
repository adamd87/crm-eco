package pl.adamd.crmsrv.offer.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.adamd.crmsrv.offer.dto.material.MaterialListOfferResponse;
import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;
import pl.adamd.crmsrv.offer.entity.Material;
import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MaterialMapper {

    List<Material> mapDtoListToMaterial(List<MaterialViewResponse> materialViewResponse);

    List<MaterialViewResponse> mapMaterialListToDto(List<Material> materials);

    Material mapDtoToMaterial(MaterialViewResponse materialViewResponse);

    MaterialViewResponse mapMaterialToDto(Material material);


}
