package pl.adamd.crmsrv.device.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.device.entity.Device;
import pl.adamd.crmsrv.device.repository.DeviceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Device findById(Long id) {
        if (!deviceRepository.existsById(id)){
            throw new RuntimeException("The specified device does not exist");
        }else {
            return deviceRepository.getById(id);
        }
    }

    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }
}
