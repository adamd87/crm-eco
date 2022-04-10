package pl.adamd.crmsrv.device.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import pl.adamd.crmsrv.common.UnitOfMeasure;
import pl.adamd.crmsrv.realization.enitity.Realization;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "devices")
@DynamicUpdate
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String producer;
    @NotNull
    private String serialNumber;
    @NotNull
    private String power;
    @NotNull
    private String category;
    @NotNull
    private BigDecimal price;

    private BigDecimal taxRate;

    private BigDecimal count;

    private boolean sold;

    private UnitOfMeasure unit;

//    @ManyToOne
//    @JoinColumn(name = "realizations_id")
//    private Realization realization;


    public BigDecimal getGrossPrice(){
       return price.multiply(taxRate).add(price).setScale(2, RoundingMode.HALF_DOWN);
    }

}
