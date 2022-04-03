package pl.adamd.crmsrv.device.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamd.crmsrv.device.service.DeviceViewService;

@RestController
@RequestMapping("/api/devices")
@AllArgsConstructor
class DeviceController {
    private final DeviceViewService deviceViewService;
}
