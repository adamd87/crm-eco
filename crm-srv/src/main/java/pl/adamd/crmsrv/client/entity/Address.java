package pl.adamd.crmsrv.client.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
    private String country;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;
    private boolean ofCorrespondence;
    private boolean ofOrder;


}
