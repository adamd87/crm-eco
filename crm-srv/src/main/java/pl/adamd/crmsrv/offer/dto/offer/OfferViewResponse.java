package pl.adamd.crmsrv.offer.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.dto.material.MaterialListOfferResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferViewResponse {

    private Long clientId;
    private String clientFullName;
    private List<MaterialListOfferResponse> materialList;
    private List<InstallationViewResponse> installationList;
    private BigDecimal totalPrice;
    private LocalDate approximateStartDate;
    private LocalDate approximateEndDate;

}
