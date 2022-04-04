package pl.adamd.crmsrv.client.service;

import pl.adamd.crmsrv.client.entity.Address;
import pl.adamd.crmsrv.client.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAllClients();

    List<Address> findAllAddresses();

    Client findClientById(Long id);
    
    Address findAddressById(Long id);

    void saveAddress(Address address);

    Client saveClient(Client client);
}
