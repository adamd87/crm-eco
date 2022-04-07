package pl.adamd.crmsrv.offer.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferViewRequest {

    private Long clientId;
    private List<Long> materialIdList;
    private List<Long> installationIdList;
    private LocalDate nearestStartDate;

}
