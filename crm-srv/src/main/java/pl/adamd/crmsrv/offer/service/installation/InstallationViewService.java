package pl.adamd.crmsrv.offer.service.installation;

import pl.adamd.crmsrv.offer.dto.installation.InstallationViewRequest;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;

import java.util.List;

public interface InstallationViewService {
    List<InstallationViewResponse> getAllInstallations();

    InstallationViewResponse getInstallationById(Long id);

    InstallationViewResponse createNewInstallation(InstallationViewRequest installationViewRequest);
}
