package pl.adamd.crmsrv.client.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

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
    @OneToMany
    private List<Address> addresses;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    private String info;
    private Boolean agreement;
    private Boolean installation;

}
