package pl.adamd.crmsrv.device.service;

import pl.adamd.crmsrv.device.entity.Device;

import java.util.List;

public interface DeviceService {
    List<Device> findAll();

    Device findById(Long id);

    Device save(Device device);
}
