package pl.adamd.crmsrv.agreement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgreementViewServiceImpl implements AgreementViewService {
    private final AgreementService agreementService;
}
