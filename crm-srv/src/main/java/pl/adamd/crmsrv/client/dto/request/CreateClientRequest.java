package pl.adamd.crmsrv.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientRequest {

    private String name;
    private String surname;
    private String phone;
    private String email;
    private String info;
    private List<AddressesRequest> addressesList;
    private Boolean agreement;
    private Boolean installation;
    private Boolean privatePerson;
    private Boolean business;
    private String nip;
    private String regon;
    private String traderName;
}
