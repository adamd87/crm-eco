package pl.adamd.crmsrv.agreement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgreementViewResponse {

    private String agreementNumber;
    private BigDecimal netContractAmount;
    private BigDecimal grossContractAmount;
    private LocalDate dateOfSigning;
}
