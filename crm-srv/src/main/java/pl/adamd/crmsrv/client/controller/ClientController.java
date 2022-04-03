package pl.adamd.crmsrv.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamd.crmsrv.client.dto.request.CreateClientRequest;
import pl.adamd.crmsrv.client.dto.response.ClientViewResponse;
import pl.adamd.crmsrv.client.service.ClientViewService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
class ClientController {
    private final ClientViewService clientViewService;

    @GetMapping
    ResponseEntity<List<ClientViewResponse>> getAllClients(){
        return ResponseEntity.ok(clientViewService.getAll());
    }

    @PostMapping
    ResponseEntity<ClientViewResponse> createNewClient(@RequestBody CreateClientRequest newClient){
        return ResponseEntity.ok(clientViewService.createClient(newClient));
    }
}
