package pl.adamd.crmsrv.offer.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;
import pl.adamd.crmsrv.realization.enitity.Realization;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materials_to_offer")
@DynamicUpdate
public class MaterialsToOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "materials_id")
    private Material material;
    private BigDecimal count;

    @ManyToOne
    @JoinColumn(name = "offers_id")
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "realizations_id")
    private Realization realization;

}
