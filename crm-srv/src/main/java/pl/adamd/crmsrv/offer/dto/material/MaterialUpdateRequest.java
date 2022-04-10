package pl.adamd.crmsrv.offer.dto.material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adamd.crmsrv.common.UnitOfMeasure;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUpdateRequest {

    private String name;
    private String producer;
    private String power;
    private String category;
    private BigDecimal price;
    private BigDecimal taxRate;
    private UnitOfMeasure unit;

}
