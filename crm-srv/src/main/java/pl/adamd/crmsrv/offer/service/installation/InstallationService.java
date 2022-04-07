package pl.adamd.crmsrv.offer.service.installation;

import pl.adamd.crmsrv.offer.entity.Installation;

import java.util.List;

public interface InstallationService {

    Installation findInstallationById(Long id);

    List<Installation> findAll();

    Installation save(Installation installation);
}
