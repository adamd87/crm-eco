package pl.adamd.crmsrv.realization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adamd.crmsrv.realization.enitity.Realization;

public interface RealizationRepository extends JpaRepository<Realization, Long> {
}
