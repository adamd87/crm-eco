package pl.adamd.crmsrv.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientDetailsRequest {

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String info;
    private Boolean agreement;
    private Boolean installation;
}
