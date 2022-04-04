package pl.adamd.crmsrv.device.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.device.dto.DeviceViewRequest;
import pl.adamd.crmsrv.device.dto.DeviceViewResponse;
import pl.adamd.crmsrv.device.entity.Device;
import pl.adamd.crmsrv.device.mapper.DeviceMapper;

import java.util.List;

import static pl.adamd.crmsrv.common.CommonUtils.setIfNotNull;

@Service
@AllArgsConstructor
public class DeviceViewServiceImpl implements DeviceViewService {
    private final DeviceService deviceService;
    private final DeviceMapper deviceMapper;

    @Override
    public List<DeviceViewResponse> getAllDevices() {
        return deviceMapper.mapListDevicesToDto(deviceService.findAll());
    }

    @Override
    public DeviceViewResponse getDeviceById(Long deviceId) {
        return deviceMapper.mapDeviceToDto(deviceService.findById(deviceId));
    }

    @Override
    public DeviceViewResponse createNewDevice(DeviceViewRequest deviceViewRequest) {
        Device newDevice = deviceService.save(deviceMapper.mapDtoToDevice(deviceViewRequest));

        return deviceMapper.mapDeviceToDto(newDevice);
    }

    @Override
    public DeviceViewResponse updateExistDevice(Long deviceId, DeviceViewRequest deviceViewRequest) {
        Device device = deviceService.findById(deviceId);

        setIfNotNull(deviceViewRequest.getName(), device::setName);
        setIfNotNull(deviceViewRequest.getProducer(), device::setProducer);
        setIfNotNull(deviceViewRequest.getSerialNumber(), device::setSerialNumber);
        setIfNotNull(deviceViewRequest.getPower(), device::setPower);
        setIfNotNull(deviceViewRequest.getCategory(), device::setCategory);
        setIfNotNull(deviceViewRequest.getPrice(), device::setPrice);

        deviceService.save(device);

        return deviceMapper.mapDeviceToDto(device);
    }
}
