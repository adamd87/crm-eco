package pl.adamd.crmsrv.offer.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.dto.material.response.MaterialListOfferResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferViewResponse {

    private Long offerId;
    private Long clientId;
    private String clientFullName;
    private List<MaterialListOfferResponse> materialList;
    private List<InstallationViewResponse> installationList;
    private BigDecimal netPrice;
    private BigDecimal taxRate;
    private BigDecimal grossPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateOfCreateOffer;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateOfLastUpdate;
    private LocalDate approximateStartDate;
    private LocalDate approximateEndDate;

}
