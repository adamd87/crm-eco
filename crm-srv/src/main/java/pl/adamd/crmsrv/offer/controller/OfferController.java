package pl.adamd.crmsrv.offer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

}
