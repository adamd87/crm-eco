package pl.adamd.crmsrv.offer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamd.crmsrv.offer.dto.material.request.UpdateOfferMaterialsVieRequest;
import pl.adamd.crmsrv.offer.dto.offer.OfferViewRequest;
import pl.adamd.crmsrv.offer.dto.offer.OfferViewResponse;
import pl.adamd.crmsrv.offer.service.offer.OfferViewService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OfferController {
    private final OfferViewService offerViewService;

    @GetMapping("/offers/get-all")
    ResponseEntity<List<OfferViewResponse>> getAllOffers() {
        return ResponseEntity.ok(offerViewService.getAllOffers());
    }

    @GetMapping("/offers/get-by-clientId/{clientId}")
    ResponseEntity<List<OfferViewResponse>> getOfferListByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(offerViewService.getOffersByClient(clientId));
    }

    @GetMapping("/offers/get-by-id/{offerId}")
    ResponseEntity<OfferViewResponse> getOfferListById(@PathVariable Long offerId) {
        return ResponseEntity.ok(offerViewService.getOffersById(offerId));
    }

    @PostMapping("/offers/create")
    ResponseEntity<OfferViewResponse> createOffer(@RequestBody OfferViewRequest offerViewRequest) {
        return ResponseEntity.ok(offerViewService.createNewOffer(offerViewRequest));
    }

    @PatchMapping("/offers/update-materials/{offerId}")
    ResponseEntity<OfferViewResponse> updateOfferMaterials(@PathVariable Long offerId, @RequestBody UpdateOfferMaterialsVieRequest request) {
        return ResponseEntity.ok(offerViewService.updateOfferMaterials(offerId, request));
    }

    @PatchMapping("/offers/increase-material-count/{offerId}")
    ResponseEntity<OfferViewResponse> increaseOffersMaterialCount(@PathVariable Long offerId, @RequestBody UpdateOfferMaterialsVieRequest request){
        return ResponseEntity.ok(offerViewService.increaseMaterialCount(offerId, request));
    }

    @PatchMapping("/offers/set-material-serial-number/{offerId}")
    ResponseEntity<OfferViewResponse> setSerialNumber(@PathVariable Long offerId, @RequestBody UpdateOfferMaterialsVieRequest request){
        return ResponseEntity.ok(offerViewService.setMaterialSerialNumber(offerId, request));
    }

    @PatchMapping("/offers/add-material/{offerId}")
    ResponseEntity<OfferViewResponse> addMaterial(@PathVariable Long offerId, @RequestBody UpdateOfferMaterialsVieRequest request){
        return ResponseEntity.ok(offerViewService.addMaterialToOffer(offerId, request));
    }




}
