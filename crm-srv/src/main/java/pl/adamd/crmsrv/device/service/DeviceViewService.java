package pl.adamd.crmsrv.device.service;

import pl.adamd.crmsrv.device.dto.DeviceViewRequest;
import pl.adamd.crmsrv.device.dto.DeviceViewResponse;

import java.util.List;

public interface DeviceViewService {
    List<DeviceViewResponse> getAllDevices();

    DeviceViewResponse getDeviceById(Long deviceId);

    DeviceViewResponse createNewDevice(DeviceViewRequest deviceViewRequest);

    DeviceViewResponse updateExistDevice(Long deviceId, DeviceViewRequest deviceViewRequest);
}
