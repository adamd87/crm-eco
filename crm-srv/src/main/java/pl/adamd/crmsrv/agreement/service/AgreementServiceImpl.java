package pl.adamd.crmsrv.agreement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.agreement.repository.AgreementRepository;

@Service
@AllArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepository agreementRepository;
}
