package pl.adamd.crmsrv.offer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;
import pl.adamd.crmsrv.offer.service.material.MaterialViewService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MaterialController {
    private final MaterialViewService materialViewService;

    @GetMapping("/materials/get-all")
    ResponseEntity<List<MaterialViewResponse>> getAll() {
        return ResponseEntity.ok(materialViewService.getAllMaterials());
    }
}
