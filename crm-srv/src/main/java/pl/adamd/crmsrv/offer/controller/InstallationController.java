package pl.adamd.crmsrv.offer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewRequest;
import pl.adamd.crmsrv.offer.dto.installation.InstallationViewResponse;
import pl.adamd.crmsrv.offer.service.installation.InstallationViewService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
class InstallationController {
    private final InstallationViewService installationViewService;

    @GetMapping("/installations/get-all")
    ResponseEntity<List<InstallationViewResponse>> getAll() {
        return ResponseEntity.ok(installationViewService.getAllInstallations());
    }

    @GetMapping("/installations/get-by-id/{installationId}")
    ResponseEntity<InstallationViewResponse> getById(@PathVariable Long installationId) {
        return ResponseEntity.ok(installationViewService.getInstallationById(installationId));
    }

    @PostMapping("/installations/create")
    ResponseEntity<InstallationViewResponse> createNew(@RequestBody InstallationViewRequest installationViewRequest) {
        return ResponseEntity.ok(installationViewService.createNewInstallation(installationViewRequest));
    }
}
