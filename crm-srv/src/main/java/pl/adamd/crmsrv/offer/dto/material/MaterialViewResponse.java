package pl.adamd.crmsrv.offer.dto.material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
