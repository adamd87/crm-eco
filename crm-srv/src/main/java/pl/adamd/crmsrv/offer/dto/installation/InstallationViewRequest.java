package pl.adamd.crmsrv.offer.dto.installation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstallationViewRequest {

    private String name;
    private String type;
    private BigDecimal price;
    private int executionTimeInDays;
}
