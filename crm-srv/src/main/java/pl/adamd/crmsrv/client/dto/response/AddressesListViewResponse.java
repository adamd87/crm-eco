package pl.adamd.crmsrv.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressesListViewResponse {

    private Long id;
    private Long clientId;
    private String clientName;
    private String clientSurname;
    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
    private String country;
    private boolean ofCorrespondence;
    private boolean ofOrder;
    private boolean headquarters;
}
