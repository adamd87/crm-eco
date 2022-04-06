package pl.adamd.crmsrv.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adamd.crmsrv.device.dto.DeviceViewResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferViewResponse {

    private Long clientId;
    private String clientFullName;
    private List<DeviceViewResponse> deviceList;
    private List<InstallationViewResponse> installationList;
    private BigDecimal totalPrice;
    private LocalDate approximateStartDate;
    private LocalDate approximateEndDate;

}
