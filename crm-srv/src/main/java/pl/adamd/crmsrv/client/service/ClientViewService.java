package pl.adamd.crmsrv.client.service;

import pl.adamd.crmsrv.client.dto.request.CreateClientRequest;
import pl.adamd.crmsrv.client.dto.response.ClientViewResponse;

import java.util.List;

public interface ClientViewService {
    List<ClientViewResponse> getAll();

    ClientViewResponse createClient(CreateClientRequest newClient);
}
