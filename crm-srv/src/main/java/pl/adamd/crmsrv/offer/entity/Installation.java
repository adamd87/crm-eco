package pl.adamd.crmsrv.offer.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
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
    @Size(min = 1, max = 100, message = "Name value cannot be empty")
    private String name;
    @NotNull(message = "Type value cannot be empty")
    private String type;
    @NotNull(message = "Price value cannot be empty")
    private BigDecimal price;
    @NotNull(message = "Days count cannot be empty")
    private int executionTimeInDays;
    @ManyToMany
    private List<Offer> offers;
}

