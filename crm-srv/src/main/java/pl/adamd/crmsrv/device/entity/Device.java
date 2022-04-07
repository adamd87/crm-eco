package pl.adamd.crmsrv.device.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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

}
