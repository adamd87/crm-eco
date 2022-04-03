package pl.adamd.crmsrv.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientAddressesViewResponse {

    private ClientViewResponse client;
    private List<AddressViewResponse> addresses;
}
