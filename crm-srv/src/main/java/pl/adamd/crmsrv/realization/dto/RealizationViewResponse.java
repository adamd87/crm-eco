package pl.adamd.crmsrv.realization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.adamd.crmsrv.agreement.dto.AgreementViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientAddressesViewResponse;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.dto.material.response.MaterialListOfferResponse;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealizationViewResponse {

    private ClientAddressesViewResponse clientDetails;
    private AgreementViewResponse agreementDetails;
    private List<MaterialListOfferResponse> materialsList;
    private List<InstallationViewResponse> installationsDetails;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateOfCreate;

}
