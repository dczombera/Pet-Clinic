package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Pet;
import czombera.dennis.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
