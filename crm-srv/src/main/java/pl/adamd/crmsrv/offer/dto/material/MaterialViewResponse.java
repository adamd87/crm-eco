package pl.adamd.crmsrv.offer.dto.material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adamd.crmsrv.common.UnitOfMeasure;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialViewResponse {

    private Long id;
    private String name;
    private String producer;
    private String power;
    private String category;
    private BigDecimal price;
    private BigDecimal taxRate;
    private BigDecimal grossPrice;
    private BigDecimal totalGrossPrice;
    private BigDecimal count;
    private UnitOfMeasure unit;
}