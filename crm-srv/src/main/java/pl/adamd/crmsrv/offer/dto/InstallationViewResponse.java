package pl.adamd.crmsrv.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstallationViewResponse {

    private Long id;
    private String name;
    private String type;
    private BigDecimal price;
    private int executionTimeInDays;
}
