package czombera.dennis.petclinic.repositories;

import czombera.dennis.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
