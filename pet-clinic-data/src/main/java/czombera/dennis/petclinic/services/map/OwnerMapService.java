package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Owner;
import czombera.dennis.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner save(Owner object) {
        return this.save(object.getId(), object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
