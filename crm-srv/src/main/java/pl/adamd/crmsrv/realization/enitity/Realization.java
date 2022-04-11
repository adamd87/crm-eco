package pl.adamd.crmsrv.realization.enitity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import pl.adamd.crmsrv.agreement.entity.Agreement;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;
import pl.adamd.crmsrv.offer.entity.Offer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "realizations")
@DynamicUpdate
public class Realization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "offers_id")
    private Offer offer;

    @OneToMany(mappedBy = "realization")
    private List<MaterialsToOffer> materials;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateOfCreate;

    private boolean inProgress;

    private boolean done;

    @ManyToOne
    @JoinColumn(name = "agreements_id")
    private Agreement agreement;

}
