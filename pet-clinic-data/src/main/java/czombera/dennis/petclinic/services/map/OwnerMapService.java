package czombera.dennis.petclinic.services.map;

import czombera.dennis.petclinic.model.Owner;
import czombera.dennis.petclinic.model.Pet;
import czombera.dennis.petclinic.model.PetType;
import czombera.dennis.petclinic.services.OwnerService;
import czombera.dennis.petclinic.services.PetService;
import czombera.dennis.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    PetType petType = pet.getPetType();
                    if (petType != null) {
                        if (petType.getId() == null) {
                            pet.setPetType(petTypeService.save(petType));
                        }
                    } else {
                        throw new RuntimeException("PetType is required for Pet record");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
    }
}
