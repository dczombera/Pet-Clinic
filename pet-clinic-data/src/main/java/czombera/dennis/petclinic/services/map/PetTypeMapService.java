package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.PetType;
import czombera.dennis.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
