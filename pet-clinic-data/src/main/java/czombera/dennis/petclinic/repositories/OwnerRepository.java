package czombera.dennis.petclinic.repositories;

import czombera.dennis.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
