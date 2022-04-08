package pl.adamd.crmsrv.realization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealizationViewRequest {

    private Long offerId;
    private Long agreementId;

}
