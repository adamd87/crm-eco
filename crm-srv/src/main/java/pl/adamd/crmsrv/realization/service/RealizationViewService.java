package pl.adamd.crmsrv.realization.service;

import pl.adamd.crmsrv.realization.dto.RealizationViewRequest;
import pl.adamd.crmsrv.realization.dto.RealizationViewResponse;

public interface RealizationViewService {
    RealizationViewResponse createNewRealization(RealizationViewRequest request);
}
