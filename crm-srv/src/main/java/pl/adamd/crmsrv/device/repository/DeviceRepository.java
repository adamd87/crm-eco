package pl.adamd.crmsrv.device.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamd.crmsrv.device.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
