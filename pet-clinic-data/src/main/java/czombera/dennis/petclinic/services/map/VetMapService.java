package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Vet;

public class VetMapService extends AbstractMapService<Vet, Long> {
    @Override
    public Vet save(Vet object) {
        return this.save(object.getId(), object);
    }
}
