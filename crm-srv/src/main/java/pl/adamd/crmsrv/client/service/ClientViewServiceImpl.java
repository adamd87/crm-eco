package pl.adamd.crmsrv.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.client.dto.request.CreateClientRequest;
import pl.adamd.crmsrv.client.dto.response.ClientViewResponse;
import pl.adamd.crmsrv.client.entity.Address;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.client.mapper.ClientMapper;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientViewServiceImpl implements ClientViewService {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientViewResponse> getAll() {
        return clientMapper.mapClientsListToDto(clientService.findAll());
    }

    @Override
    @Transactional
    public ClientViewResponse createClient(CreateClientRequest newClient) {

        List<Address> addresses = clientMapper.mapDtoListToAddresses(newClient.getAddressesList());

        Client client = Client.builder()
                .name(newClient.getName())
                .surname(newClient.getSurname())
                .phone(newClient.getPhone())
                .email(newClient.getEmail())
                .info(newClient.getInfo())
                .addresses(addresses)
                .installation(newClient.isInstallation())
                .agreement(newClient.isInstallation())
                .build();

        clientService.saveClient(client);

        for (Address address: addresses) {
            address.setClient(client);
            clientService.saveAddress(address);
        }

        return clientMapper.mapClientToDto(client);
    }
}
