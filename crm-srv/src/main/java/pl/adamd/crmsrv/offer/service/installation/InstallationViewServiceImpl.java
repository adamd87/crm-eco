package pl.adamd.crmsrv.offer.service.installation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewRequest;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.entity.Installation;
import pl.adamd.crmsrv.offer.mapper.InstallationMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class InstallationViewServiceImpl implements InstallationViewService {
    private final InstallationService installationService;
    private final InstallationMapper installationMapper;

    @Override
    public List<InstallationViewResponse> getAllInstallations() {
        return installationMapper.installationListToDto(installationService.findAll());
    }

    @Override
    public InstallationViewResponse getInstallationById(Long id) {
        return installationMapper.mapInstallationToDto(installationService.findInstallationById(id));
    }

    @Override
    public InstallationViewResponse createNewInstallation(InstallationViewRequest installationViewRequest) {
        Installation newInstallation = installationMapper.mapDtoToInstallation(installationViewRequest);
        newInstallation.setGrossPrice(newInstallation.getGrossPrice());

        installationService.save(newInstallation);

        return installationMapper.mapInstallationToDto(newInstallation);
    }

}
