package pl.adamd.crmsrv.realization.enitity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import pl.adamd.crmsrv.agreement.entity.Agreement;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.device.entity.Device;
import pl.adamd.crmsrv.offer.dto.material.MaterialListOfferResponse;
import pl.adamd.crmsrv.offer.entity.Installation;
import pl.adamd.crmsrv.offer.entity.Material;
import pl.adamd.crmsrv.offer.entity.MaterialsToOffer;
import pl.adamd.crmsrv.offer.entity.Offer;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "realization")
    private List<Device> specifyDevice;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    private boolean inProgress;

    private boolean done;

    @ManyToOne
    @JoinColumn(name = "agreements_id")
    private Agreement agreement;

}
