package pl.adamd.crmsrv.offer.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.adamd.crmsrv.offer.dto.material.MaterialListOfferResponse;
import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MaterialsToOfferMapper {

    MaterialListOfferResponse mapOfferMaterialsToDto(MaterialsToOffer materialsToOffer);

    List<MaterialListOfferResponse> mapOfferListToDto(List<MaterialsToOffer> materialsToOfferList);

}
