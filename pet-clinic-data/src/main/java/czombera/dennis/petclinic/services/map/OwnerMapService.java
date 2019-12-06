package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Owner;

public class OwnerMapService extends AbstractMapService<Owner, Long> {
    @Override
    public Owner save(Owner object) {
        return this.save(object.getId(), object);
    }
}
