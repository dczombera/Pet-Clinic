package czombera.dennis.petclinic.repositories;

import czombera.dennis.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
