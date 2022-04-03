//package pl.adamd.crmsrv.realization.enitity;
//
//import lombok.*;
//import org.hibernate.annotations.DynamicUpdate;
//import pl.adamd.crmsrv.client.entity.Client;
//import pl.adamd.crmsrv.offer.entity.Offer;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "realizations")
//@DynamicUpdate
//public class Realization {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "offers_id")
//    private Offer offer;
//    @OneToOne
//    @JoinColumn(name = "clients_id")
//    private Client client;
//}
