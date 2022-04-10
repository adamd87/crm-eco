package pl.adamd.crmsrv.agreement.service;

import pl.adamd.crmsrv.agreement.entity.Agreement;

import java.util.List;

public interface AgreementService {
    List<Agreement> findAll();

    boolean findByAgreementNumber(String agreementNumber);

    Agreement save(Agreement agreement);
}
