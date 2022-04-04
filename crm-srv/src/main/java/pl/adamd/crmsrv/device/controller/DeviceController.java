package pl.adamd.crmsrv.device.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamd.crmsrv.device.dto.DeviceViewRequest;
import pl.adamd.crmsrv.device.dto.DeviceViewResponse;
import pl.adamd.crmsrv.device.entity.Device;
import pl.adamd.crmsrv.device.service.DeviceViewService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
class DeviceController {
    private final DeviceViewService deviceViewService;

    @GetMapping("/devices/get-all")
    ResponseEntity<List<DeviceViewResponse>> getAllDevices() {
        return ResponseEntity.ok(deviceViewService.getAllDevices());
    }

    @GetMapping("/devices/get-by-id/{deviceId}")
    ResponseEntity<DeviceViewResponse> getDeviceById(@PathVariable Long deviceId){
        return ResponseEntity.ok(deviceViewService.getDeviceById(deviceId));
    }

    @PostMapping("/devices/create")
    ResponseEntity<DeviceViewResponse> addDevice(@RequestBody DeviceViewRequest deviceViewRequest){
        return ResponseEntity.ok(deviceViewService.createNewDevice(deviceViewRequest));
    }

    @PatchMapping("/devices/update/{deviceId}")
    ResponseEntity<DeviceViewResponse> updateDevice(@PathVariable Long deviceId, @RequestBody DeviceViewRequest deviceViewRequest){
        return ResponseEntity.ok(deviceViewService.updateExistDevice(deviceId, deviceViewRequest));
    }
}
