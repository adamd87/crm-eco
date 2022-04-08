package pl.adamd.crmsrv.offer.dto.material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialsViewRequest {

    private Long materialId;
    private BigDecimal count;
}
