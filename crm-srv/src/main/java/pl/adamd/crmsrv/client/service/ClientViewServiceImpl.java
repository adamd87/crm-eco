package pl.adamd.crmsrv.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.client.dto.request.CreateClientRequest;
import pl.adamd.crmsrv.client.dto.request.UpdateClientAddressesRequest;
import pl.adamd.crmsrv.client.dto.request.UpdateClientDetailsRequest;
import pl.adamd.crmsrv.client.dto.response.AddressesListViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientAddressesViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientViewResponse;
import pl.adamd.crmsrv.client.entity.Address;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.client.mapper.ClientMapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static pl.adamd.crmsrv.common.CommonUtils.setIfNotNull;

@Service
@AllArgsConstructor
public class ClientViewServiceImpl implements ClientViewService {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientViewResponse> getAll() {
        return clientMapper.mapClientsListToDto(clientService.findAllClients());
    }

    @Override
    @Transactional
    public ClientViewResponse createClient(CreateClientRequest newClient) {

        Address address = Address.builder()
                .street(newClient.getStreet())
                .buildingNumber(newClient.getBuildingNumber())
                .apartmentNumber(newClient.getApartmentNumber())
                .postCode(newClient.getPostCode())
                .city(newClient.getCity())
                .build();

        List<Address> newAddressList = new ArrayList<>();
        newAddressList.add(address);

        Client client = createNewClient(newClient, newAddressList);

        assigningClientToAddresses(newAddressList, client);

        return clientMapper.mapClientToDto(client);
    }

    @Override
    public ClientViewResponse updateClient(Long clientId, UpdateClientDetailsRequest updateClientDetails) {

        Client client = getSpecifiedClient(clientId);

        setIfNotNull(updateClientDetails.getName(), client::setName);
        setIfNotNull(updateClientDetails.getSurname(), client::setSurname);
        setIfNotNull(updateClientDetails.getPhone(), client::setPhone);
        setIfNotNull(updateClientDetails.getEmail(), client::setEmail);
        setIfNotNull(updateClientDetails.getInfo(), client::setInfo);
        setIfNotNull(updateClientDetails.getAgreement(), client::setAgreement);
        setIfNotNull(updateClientDetails.getInstallation(), client::setInstallation);
        setIfNotNull(updateClientDetails.getPrivatePerson(), client::setPrivatePerson);
        setIfNotNull(updateClientDetails.getBusiness(), client::setBusiness);
        setIfNotNull(updateClientDetails.getNip(), client::setNip);
        setIfNotNull(updateClientDetails.getRegon(), client::setRegon);
        setIfNotNull(updateClientDetails.getTraderName(), client::setTraderName);

        client = clientService.saveClient(client);

        return clientMapper.mapClientToDto(client);
    }

    @Override
    public ClientAddressesViewResponse updateClientAddresses(UpdateClientAddressesRequest clientAddressesRequest) {
        Client client;

        if (clientAddressesRequest.getId() == null && clientAddressesRequest.getClientId() != null) {
            client = addNewClientAddress(clientAddressesRequest);
        } else {
            Address address = updateExistAddress(clientAddressesRequest);
            client = address.getClient();
        }

        return new ClientAddressesViewResponse(
                clientMapper.mapClientToDto(client),
                clientMapper.mapAddressesListToDto(client.getAddresses()));

    }

    @Override
    public List<AddressesListViewResponse> getAllAddresses() {
        List<Address> addressList = clientService.findAllAddresses();
        return getAddressesListViewResponses(addressList);

    }

    @Override
    public ClientAddressesViewResponse getClientById(Long id) {
        Client client = clientService.findClientById(id);

        return new ClientAddressesViewResponse(
                clientMapper.mapClientToDto(client),
                clientMapper.mapAddressesListToDto(client.getAddresses())
        );
    }

    private List<AddressesListViewResponse> getAddressesListViewResponses(List<Address> addressList) {
        List<AddressesListViewResponse> responseList = new ArrayList<>();
        for (Address address : addressList) {
            Client client = address.getClient();
            AddressesListViewResponse response = AddressesListViewResponse.builder()
                    .id(address.getId())
                    .clientId(client.getId())
                    .clientName(client.getName())
                    .clientSurname(client.getSurname())
                    .street(address.getStreet())
                    .buildingNumber(address.getBuildingNumber())
                    .apartmentNumber(address.getApartmentNumber())
                    .postCode(address.getPostCode())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .ofCorrespondence(address.isOfCorrespondence())
                    .ofOrder(address.isOfOrder())
                    .build();
            responseList.add(response);
        }
        return responseList;
    }

    private Address updateExistAddress(UpdateClientAddressesRequest clientAddressesRequest) {
        Address address = clientService.findAddressById(clientAddressesRequest.getId());
        setIfNotNull(clientAddressesRequest.getStreet(), address::setStreet);
        setIfNotNull(clientAddressesRequest.getBuildingNumber(), address::setBuildingNumber);
        setIfNotNull(clientAddressesRequest.getApartmentNumber(), address::setApartmentNumber);
        setIfNotNull(clientAddressesRequest.getPostCode(), address::setPostCode);
        setIfNotNull(clientAddressesRequest.getCity(), address::setCity);
        setIfNotNull(clientAddressesRequest.getCountry(), address::setCountry);
        setIfNotNull(clientAddressesRequest.isOfCorrespondence(), address::setOfCorrespondence);
        setIfNotNull(clientAddressesRequest.isOfOrder(), address::setOfOrder);
        setIfNotNull(clientAddressesRequest.isHeadquarters(), address::setHeadquarters);
        clientService.saveAddress(address);
        clientService.saveClient(address.getClient());
        return address;
    }

    private Client addNewClientAddress(UpdateClientAddressesRequest clientAddressesRequest) {
        Client client = clientService.findClientById(clientAddressesRequest.getClientId());
        Address address = Address.builder()
                .street(clientAddressesRequest.getStreet())
                .buildingNumber(clientAddressesRequest.getBuildingNumber())
                .apartmentNumber(clientAddressesRequest.getApartmentNumber())
                .postCode(clientAddressesRequest.getPostCode())
                .city(clientAddressesRequest.getCity())
                .country(clientAddressesRequest.getCountry())
                .client(client)
                .ofCorrespondence(clientAddressesRequest.isOfCorrespondence())
                .ofOrder(clientAddressesRequest.isOfOrder())
                .headquarters(clientAddressesRequest.isHeadquarters())
                .build();
        clientService.saveAddress(address);
        client.getAddresses().add(address);

        return clientService.saveClient(client);
    }

    private Client getSpecifiedClient(Long clientId) {
        if (clientId == null) {
            throw new RuntimeException("The client id was not specified");
        } else {
            return clientService.findClientById(clientId);
        }
    }

    private void assigningClientToAddresses(List<Address> addresses, Client client) {
        for (Address address : addresses) {
            address.setClient(client);
            clientService.saveAddress(address);
        }
    }

    private Client createNewClient(CreateClientRequest newClient, List<Address> addresses) {


        Client client = Client.builder()
                .name(newClient.getName())
                .surname(newClient.getSurname())
                .phone(newClient.getPhone())
                .email(newClient.getEmail())
                .info(newClient.getInfo())
                .addresses(addresses)
                .agreement(newClient.getAgreement())
                .privatePerson(newClient.getPrivatePerson())
                .business(newClient.getBusiness())
                .nip(newClient.getNip())
                .build();

        return clientService.saveClient(client);
    }
}
