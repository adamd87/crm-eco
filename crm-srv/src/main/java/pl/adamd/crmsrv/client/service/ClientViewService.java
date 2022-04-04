package pl.adamd.crmsrv.client.service;

import pl.adamd.crmsrv.client.dto.request.CreateClientRequest;
import pl.adamd.crmsrv.client.dto.request.UpdateClientAddressesRequest;
import pl.adamd.crmsrv.client.dto.request.UpdateClientDetailsRequest;
import pl.adamd.crmsrv.client.dto.response.AddressesListViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientAddressesViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientViewResponse;

import java.util.List;

public interface ClientViewService {
    List<ClientViewResponse> getAll();

    ClientViewResponse createClient(CreateClientRequest newClient);

    ClientViewResponse updateClient(Long clientId, UpdateClientDetailsRequest updateClientDetails);

    ClientAddressesViewResponse updateClientAddresses(UpdateClientAddressesRequest clientAddressesRequest);

    List<AddressesListViewResponse> getAllAddresses();

    ClientAddressesViewResponse getClientById(Long id);
}
