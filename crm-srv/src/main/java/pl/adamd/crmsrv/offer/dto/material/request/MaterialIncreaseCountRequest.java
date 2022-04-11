package pl.adamd.crmsrv.offer.dto.material.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialIncreaseCountRequest {

    private BigDecimal increaseBy;
}
