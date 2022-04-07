package pl.adamd.crmsrv.offer.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewRequest;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.entity.Installation;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InstallationMapper {
    List<InstallationViewResponse> installationListToDto(List<Installation> installationList);

    InstallationViewResponse mapInstallationToDto(Installation installation);

    Installation mapDtoToInstallation(InstallationViewRequest installationViewRequest);
}
