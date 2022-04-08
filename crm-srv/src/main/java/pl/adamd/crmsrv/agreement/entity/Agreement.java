package pl.adamd.crmsrv.agreement.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.realization.enitity.Realization;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agreements")
@DynamicUpdate
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    private BigDecimal grossContractAmount;

    private LocalDate dateOfSigning;

    @OneToMany(mappedBy = "agreement")
    private List<Realization> realizations;

}
