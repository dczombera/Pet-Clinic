package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Visit;
import czombera.dennis.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit object graph");
        }
        return super.save(visit);
    }
}
