package czombera.dennis.petclinic.services;

import czombera.dennis.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
