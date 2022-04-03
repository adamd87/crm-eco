package pl.adamd.crmsrv.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.client.entity.Address;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.client.repository.AddressRepository;
import pl.adamd.crmsrv.client.repository.ClientRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Client findClientById(Long id) {
        if (!clientRepository.existsById(id)){
            throw new RuntimeException("The specified client does not exist");
        } else {
            return clientRepository.getById(id);
        }
    }

    @Override
    public Address findAddressById(Long id) {
        if (!addressRepository.existsById(id)){
            throw new RuntimeException("The specified address does not exist");
        }else {
            return addressRepository.getById(id);
        }
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
