package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.PetType;
import czombera.dennis.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
