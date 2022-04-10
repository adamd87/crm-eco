package pl.adamd.crmsrv.agreement.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.adamd.crmsrv.agreement.dto.AgreementViewResponse;
import pl.adamd.crmsrv.agreement.entity.Agreement;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AgreementMapper {

    AgreementViewResponse mapAgreementToDto(Agreement agreement);
}
