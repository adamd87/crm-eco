package pl.adamd.crmsrv.offer.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.adamd.crmsrv.offer.dto.InstallationViewResponse;
import pl.adamd.crmsrv.offer.entity.Installation;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InstallationMapper {
    List<InstallationViewResponse> installationListToDto(List<Installation> installationList);
}
