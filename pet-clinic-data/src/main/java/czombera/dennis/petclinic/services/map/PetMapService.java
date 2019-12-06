package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Pet;

public class PetMapService extends AbstractMapService<Pet, Long> {
    @Override
    public Pet save(Pet object) {
        return this.save(object.getId(), object);
    }
}
