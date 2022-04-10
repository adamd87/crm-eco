package pl.adamd.crmsrv.offer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamd.crmsrv.offer.dto.material.MaterialListOfferResponse;
import pl.adamd.crmsrv.offer.dto.material.MaterialViewResponse;
import pl.adamd.crmsrv.offer.service.materialToOffer.MaterialsToOfferViewService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MaterialsToOfferController {
    private final MaterialsToOfferViewService materialsToOfferViewService;

    @GetMapping("/materials/to-offer/get-all")
    ResponseEntity<List<MaterialListOfferResponse>> getAll(){
        return ResponseEntity.ok(materialsToOfferViewService.findAll());
    }

}
