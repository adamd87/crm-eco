package pl.adamd.crmsrv.agreement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamd.crmsrv.agreement.service.AgreementViewService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class AgreementController {
    private final AgreementViewService agreementViewService;
}
