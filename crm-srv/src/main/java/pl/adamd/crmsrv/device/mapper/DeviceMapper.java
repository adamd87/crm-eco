package pl.adamd.crmsrv.device.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.adamd.crmsrv.device.dto.DeviceViewRequest;
import pl.adamd.crmsrv.device.dto.DeviceViewResponse;
import pl.adamd.crmsrv.device.entity.Device;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DeviceMapper {

    List<DeviceViewResponse> mapListDevicesToDto(List<Device> deviceList);

    DeviceViewResponse mapDeviceToDto(Device device);

    Device mapDtoToDevice(DeviceViewRequest deviceViewRequest);
}
