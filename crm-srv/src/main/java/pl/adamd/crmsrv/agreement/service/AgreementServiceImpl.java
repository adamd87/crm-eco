package pl.adamd.crmsrv.agreement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.agreement.entity.Agreement;
import pl.adamd.crmsrv.agreement.repository.AgreementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepository agreementRepository;

    @Override
    public List<Agreement> findAll() {
        return agreementRepository.findAll();
    }

    @Override
    public boolean findByAgreementNumber(String agreementNumber) {
            return agreementRepository.findAll().stream().anyMatch(
                    agreement -> agreement.getAgreementNumber().equals(agreementNumber));
    }

    @Override
    public Agreement save(Agreement agreement) {
        return agreementRepository.save(agreement);
    }
}
