package pl.adamd.crmsrv.realization.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamd.crmsrv.realization.service.RealizationService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RealizationController {
    private final RealizationService realizationService;
}
