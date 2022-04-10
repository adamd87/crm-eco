package pl.adamd.crmsrv.device.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adamd.crmsrv.common.UnitOfMeasure;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceOrderViewResponse {
    private Long id;
    private String name;
    private String producer;
    private String serialNumber;
    private String power;
    private String category;
    private BigDecimal price;
    private BigDecimal taxRate;
    private BigDecimal orderCount;
    private UnitOfMeasure unit;
}
