package pl.adamd.crmsrv.client.dto.request;


import lombok.Data;

@Data
public class CreateClientRequest {

    /*  Client details:    */
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String info;
    private Boolean agreement;
    private Boolean privatePerson;
    private Boolean business;
    private String nip;
    private String traderName;

    /*  Address details:    */
    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
    private String country;


}
