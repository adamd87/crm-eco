package pl.adamd.crmsrv.realization.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.realization.enitity.Realization;
import pl.adamd.crmsrv.realization.repository.RealizationRepository;

@Service
@AllArgsConstructor
public class RealizationServiceImpl implements RealizationService {
    private final RealizationRepository realizationRepository;


    @Override
    public Realization save(Realization realization) {
        return realizationRepository.save(realization);
    }
}
