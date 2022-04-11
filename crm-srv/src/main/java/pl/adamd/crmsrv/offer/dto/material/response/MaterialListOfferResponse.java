package pl.adamd.crmsrv.offer.dto.material.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialListOfferResponse {

    private MaterialViewResponse material;
    private BigDecimal count;
    private String serialNumber;
}
