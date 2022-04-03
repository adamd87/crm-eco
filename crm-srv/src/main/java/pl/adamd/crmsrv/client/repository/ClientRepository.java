package pl.adamd.crmsrv.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamd.crmsrv.client.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
