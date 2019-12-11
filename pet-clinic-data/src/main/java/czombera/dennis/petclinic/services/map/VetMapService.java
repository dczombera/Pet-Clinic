package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Vet;
import czombera.dennis.petclinic.services.SpecialtyService;
import czombera.dennis.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialties().size() > 0) {
            vet.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    specialtyService.save(specialty);
                }
            });
        }
        return super.save(vet);
    }
}
