package pl.adamd.crmsrv.offer.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adamd.crmsrv.offer.dto.material.request.MaterialsViewRequest;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferViewRequest {

    private Long clientId;
    private List<MaterialsViewRequest> materialIdList;
    private List<Long> installationIdList;
    private LocalDate nearestStartDate;

}
