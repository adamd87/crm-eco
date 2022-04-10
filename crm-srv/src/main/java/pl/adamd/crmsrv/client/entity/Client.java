package pl.adamd.crmsrv.client.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import pl.adamd.crmsrv.agreement.entity.Agreement;
import pl.adamd.crmsrv.offer.entity.Offer;
import pl.adamd.crmsrv.realization.enitity.Realization;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
@DynamicUpdate
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String name;
    private String surname;
    @OneToMany(mappedBy = "client")
    private List<Address> addresses;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    private String info;
    private Boolean agreement;
    private Boolean installation;
    private Boolean privatePerson;
    private Boolean business;
    private String nip;
    private String regon;
    private String traderName;

    @OneToMany(mappedBy = "client")
    private List<Offer> offers;

    @OneToMany(mappedBy = "client")
    private List<Realization> realizations;

    @OneToMany(mappedBy = "client")
    private List<Agreement> agreements;

}
