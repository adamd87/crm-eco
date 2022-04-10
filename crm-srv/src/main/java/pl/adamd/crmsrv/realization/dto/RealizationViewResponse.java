package pl.adamd.crmsrv.realization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adamd.crmsrv.agreement.dto.AgreementViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientAddressesViewResponse;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.dto.material.MaterialListOfferResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealizationViewResponse {

    private ClientAddressesViewResponse clientDetails;
    private AgreementViewResponse agreementDetails;
    private List<MaterialListOfferResponse> materialsList;
    private List<InstallationViewResponse> installationsDetails;

}
