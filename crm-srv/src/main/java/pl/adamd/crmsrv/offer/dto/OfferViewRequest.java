package pl.adamd.crmsrv.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.device.entity.Device;
import pl.adamd.crmsrv.offer.entity.Installation;


import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferViewRequest {

    private Client client;
    private List<Device> devices;
    private List<Installation> installationList;
    private LocalDate nearestStartDate;

}
