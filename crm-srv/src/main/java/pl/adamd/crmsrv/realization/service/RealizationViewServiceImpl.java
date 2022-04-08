package pl.adamd.crmsrv.realization.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RealizationViewServiceImpl implements RealizationViewService {
    private final RealizationService realizationService;
}
