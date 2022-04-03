package pl.adamd.crmsrv.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.client.entity.Address;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.client.repository.AddressRepository;
import pl.adamd.crmsrv.client.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
