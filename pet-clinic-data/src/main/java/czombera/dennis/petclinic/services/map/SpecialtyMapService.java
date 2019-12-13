package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Specialty;
import czombera.dennis.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
}
