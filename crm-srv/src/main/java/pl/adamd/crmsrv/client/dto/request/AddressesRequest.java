package pl.adamd.crmsrv.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressesRequest {

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

