package pl.adamd.crmsrv.realization.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamd.crmsrv.realization.dto.RealizationViewRequest;
import pl.adamd.crmsrv.realization.dto.RealizationViewResponse;
import pl.adamd.crmsrv.realization.service.RealizationService;
import pl.adamd.crmsrv.realization.service.RealizationViewService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RealizationController {
    private final RealizationViewService realizationViewService;

    @PostMapping("/realizations/add-new")
    ResponseEntity<RealizationViewResponse> addNewRealization(@RequestBody RealizationViewRequest request){
        return ResponseEntity.ok(realizationViewService.createNewRealization(request));
    }
}
