package pl.adamd.crmsrv.offer.service.installation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.offer.entity.Installation;
import pl.adamd.crmsrv.offer.repository.InstallationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class InstallationServiceImpl implements InstallationService {
    private final InstallationRepository installationRepository;

    @Override
    public Installation findInstallationById(Long id) {
        if (!installationRepository.existsById(id)) {
            throw new RuntimeException("The specified installation does not exist");
        } else {
            return installationRepository.getById(id);
        }
    }

    @Override
    public List<Installation> findAll() {
        return installationRepository.findAll();
    }

    @Override
    public Installation save(Installation installation) {
        return installationRepository.save(installation);
    }


}
