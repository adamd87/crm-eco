package pl.adamd.crmsrv.device.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceViewServiceImpl implements DeviceViewService {
    private final DeviceService deviceService;
}
