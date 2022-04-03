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
    private boolean agreement;
    private boolean installation;
}
