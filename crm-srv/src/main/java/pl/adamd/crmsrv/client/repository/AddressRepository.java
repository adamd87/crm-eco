package pl.adamd.crmsrv.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamd.crmsrv.client.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
