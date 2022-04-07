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

    @NotNull(message = "Name value cannot be empty")
    private String name;
    @NotNull(message = "Producer value cannot be empty")
    private String producer;
    @NotNull(message = "Serial number value cannot be empty")
    private String serialNumber;
    @NotNull(message = "Power value cannot be empty")
    private String power;
    @NotNull(message = "Category value cannot be empty")
    private String category;
    @NotNull(message = "Price value cannot be empty")
    private BigDecimal price;

}
