package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Pet;
import czombera.dennis.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
