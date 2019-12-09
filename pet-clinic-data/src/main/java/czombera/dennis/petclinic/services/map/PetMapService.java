package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Pet;
import czombera.dennis.petclinic.services.PetService;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet save(Pet object) {
        return this.save(object.getId(), object);
    }
}
