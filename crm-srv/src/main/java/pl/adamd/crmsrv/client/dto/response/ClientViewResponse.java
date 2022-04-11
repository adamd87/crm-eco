package pl.adamd.crmsrv.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientViewResponse {

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String info;
    private Boolean agreement;
    private Boolean installation;
    private Boolean privatePerson;
    private Boolean business;
    private String nip;
    private String regon;
    private String traderName;
}
