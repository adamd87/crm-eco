package pl.adamd.crmsrv.offer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamd.crmsrv.offer.dto.material.*;
import pl.adamd.crmsrv.offer.service.material.MaterialViewService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MaterialController {
    private final MaterialViewService materialViewService;

    @GetMapping("/materials/get-all")
    ResponseEntity<List<MaterialsListViewResponse>> getAll() {
        return ResponseEntity.ok(materialViewService.getAllMaterials());
    }

    @PostMapping("/materials/add-material")
    ResponseEntity<MaterialViewResponse> createOne(@RequestBody MaterialCreateRequest materialCreateRequest) {
        return ResponseEntity.ok(materialViewService.addNewMaterial(materialCreateRequest));
    }

    @PatchMapping("materials/update/{materialId}")
    ResponseEntity<MaterialViewResponse> updateById(@PathVariable Long materialId,
                                                    @RequestBody MaterialUpdateRequest request) {
        return ResponseEntity.ok(materialViewService.updateMaterial(materialId, request));
    }

    @PatchMapping("/materials/increase/{materialId}")
    ResponseEntity<MaterialViewResponse> increaseById(@PathVariable Long materialId,
                                                    @RequestBody MaterialIncreaseCountRequest request){
        return ResponseEntity.ok(materialViewService.increaseMaterialCount(materialId, request));
    }

}
