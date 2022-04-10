package pl.adamd.crmsrv.offer.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "installations")
@DynamicUpdate
public class Installation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private BigDecimal price;
    private BigDecimal taxRate;
    private BigDecimal grossPrice;
    @NotNull
    private int executionTimeInDays;
    @ManyToMany
    private List<Offer> offers;

    public BigDecimal getGrossPrice(){
        return price.multiply(taxRate).add(price).setScale(2, RoundingMode.HALF_DOWN);
    }

}

