package pl.adamd.crmsrv.agreement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adamd.crmsrv.agreement.entity.Agreement;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
}
