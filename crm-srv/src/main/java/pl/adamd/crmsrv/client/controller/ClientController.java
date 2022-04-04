package pl.adamd.crmsrv.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamd.crmsrv.client.dto.request.CreateClientRequest;
import pl.adamd.crmsrv.client.dto.request.UpdateClientAddressesRequest;
import pl.adamd.crmsrv.client.dto.request.UpdateClientDetailsRequest;
import pl.adamd.crmsrv.client.dto.response.AddressesListViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientAddressesViewResponse;
import pl.adamd.crmsrv.client.dto.response.ClientViewResponse;
import pl.adamd.crmsrv.client.service.ClientViewService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
class ClientController {
    private final ClientViewService clientViewService;

    @GetMapping("/clients/list")
    ResponseEntity<List<ClientViewResponse>> getAllClients() {
        return ResponseEntity.ok(clientViewService.getAll());
    }

    @GetMapping("/clients/addresses/list")
    ResponseEntity<List<AddressesListViewResponse>> getAllAddresses() {
        return ResponseEntity.ok(clientViewService.getAllAddresses());
    }

    @GetMapping("/clients/get-by-id/{clientId}")
    ResponseEntity<ClientAddressesViewResponse> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientViewService.getClientById(clientId));
    }

    @PostMapping("/clients/create")
    ResponseEntity<ClientViewResponse> createNewClient(@RequestBody CreateClientRequest newClient) {
        return ResponseEntity.ok(clientViewService.createClient(newClient));
    }

    @PatchMapping("/clients/update/{clientId}")
    ResponseEntity<ClientViewResponse> updateClient(@PathVariable Long clientId, @RequestBody UpdateClientDetailsRequest updateClientDetails) {
        return ResponseEntity.ok(clientViewService.updateClient(clientId, updateClientDetails));
    }

    @PatchMapping("/clients/addresses/update")
    ResponseEntity<ClientAddressesViewResponse> updateClientAddresses(@RequestBody UpdateClientAddressesRequest clientAddressesRequest) {
        return ResponseEntity.ok(clientViewService.updateClientAddresses(clientAddressesRequest));
    }
}
