package pl.adamd.crmsrv.client.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.adamd.crmsrv.client.dto.request.AddressesRequest;
import pl.adamd.crmsrv.client.dto.response.AddressViewResponse;
import pl.adamd.crmsrv.client.dto.response.AddressesListViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientViewResponse;
import pl.adamd.crmsrv.client.entity.Address;
import pl.adamd.crmsrv.client.entity.Client;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper {

    ClientViewResponse mapClientToDto(Client client);

    List<ClientViewResponse> mapClientsListToDto(List<Client> clientList);

    List<Address> mapDtoListToAddresses(List<AddressesRequest> addressesRequestList);

    List<AddressViewResponse> mapAddressesListToDto(List<Address> addressList);

}
