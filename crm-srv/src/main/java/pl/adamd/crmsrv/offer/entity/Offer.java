package pl.adamd.crmsrv.offer.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import pl.adamd.crmsrv.client.entity.Client;

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
@Table(name = "offers")
@DynamicUpdate
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;
    @ManyToMany
    private List<Material> materials;
    @ManyToMany
    private List<Installation> installationList;
    private BigDecimal totalPrice;
    private LocalDate dayOfStart;
    private LocalDate dayOfEnd;
    private boolean accepted;

}
