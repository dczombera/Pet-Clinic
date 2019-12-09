package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Vet;
import czombera.dennis.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet save(Vet object) {
        return this.save(object.getId(), object);
    }
}
