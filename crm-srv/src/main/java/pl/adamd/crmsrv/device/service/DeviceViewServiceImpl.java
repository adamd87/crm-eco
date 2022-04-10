package pl.adamd.crmsrv.device.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.common.MaterialsFlag;
import pl.adamd.crmsrv.device.dto.DeviceViewRequest;
import pl.adamd.crmsrv.device.dto.DeviceViewResponse;
import pl.adamd.crmsrv.device.entity.Device;
import pl.adamd.crmsrv.device.mapper.DeviceMapper;
import pl.adamd.crmsrv.offer.entity.Material;
import pl.adamd.crmsrv.offer.service.material.MaterialService;

import java.util.List;

import static pl.adamd.crmsrv.common.CommonUtils.setIfNotNull;

@Service
@AllArgsConstructor
public class DeviceViewServiceImpl implements DeviceViewService {
    private final DeviceService deviceService;
    private final DeviceMapper deviceMapper;
    private final MaterialService materialService;

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
        addNewMaterial(newDevice);

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
        setIfNotNull(deviceViewRequest.getTaxRate(), device::setTaxRate);
        setIfNotNull(deviceViewRequest.getCount(), device::setCount);
        setIfNotNull(deviceViewRequest.getUnit(), device::setUnit);

        deviceService.save(device);

        return deviceMapper.mapDeviceToDto(device);
    }

    private void addNewMaterial(Device newDevice) {
        if (materialService.findAll().stream()
                .noneMatch(m -> m.getName().equals(newDevice.getName()) &&
                        m.getProducer().equals(newDevice.getProducer()) &&
                        m.getPower().equals(newDevice.getPower()) &&
                        m.getCategory().equals(newDevice.getCategory()) &&
                        m.getPrice().equals(newDevice.getPrice()))) {
            Material material = Material.builder()
                    .name(newDevice.getName())
                    .producer(newDevice.getProducer())
                    .power(newDevice.getPower())
                    .category(newDevice.getCategory())
                    .price(newDevice.getPrice())
                    .taxRate(newDevice.getTaxRate())
                    .count(newDevice.getCount())
                    .unit(newDevice.getUnit())
                    .materialsFlag(MaterialsFlag.device)
                    .build();
            materialService.save(material);
        }
    }
}
