package pl.adamd.crmsrv.offer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamd.crmsrv.client.entity.Client;
import pl.adamd.crmsrv.client.service.ClientService;
import pl.adamd.crmsrv.offer.entity.Offer;
import pl.adamd.crmsrv.offer.repository.OfferRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ClientService clientService;

    @Override
    public List<Offer> findAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<Offer> findByClientId(Long id) {
        Client client = clientService.findClientById(id);

        List<Offer> offerList = offerRepository.findAll().stream().filter(offer -> offer.getClient() == client).collect(Collectors.toList());

        if (offerList.size() == 0) {
            throw new RuntimeException("Offer list is empty");
        } else {
            return offerList;
        }
    }

    @Override
    public Offer findById(Long id) {
        if (!offerRepository.existsById(id)){
            throw new RuntimeException("The specified offer does not exist");
        } else {
            return offerRepository.getById(id);
        }
    }
}
