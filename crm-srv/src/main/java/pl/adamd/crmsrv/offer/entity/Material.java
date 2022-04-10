package pl.adamd.crmsrv.offer.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import pl.adamd.crmsrv.common.MaterialsFlag;
import pl.adamd.crmsrv.common.UnitOfMeasure;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materials")
@DynamicUpdate
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String producer;
    private String power;
    private String category;
    private BigDecimal price;
    private BigDecimal taxRate;
    private BigDecimal grossPrice;
    private BigDecimal count;
    private UnitOfMeasure unit;
    private MaterialsFlag materialsFlag;


    @OneToMany
    private List<MaterialsToOffer> materials;

    public BigDecimal getGrossPrice(){
        return price.multiply(taxRate).add(price).setScale(2, RoundingMode.HALF_DOWN);
    }

}
