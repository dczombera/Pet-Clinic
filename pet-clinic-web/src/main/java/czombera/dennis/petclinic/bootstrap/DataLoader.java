package czombera.dennis.petclinic.bootstrap;

import czombera.dennis.petclinic.model.*;
import czombera.dennis.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = PetType.builder().name("Dog").build();
        petTypeService.save(dog);

        PetType cat = PetType.builder().name("Cat").build();
        petTypeService.save(cat);

        Specialty radiology = Specialty.builder().description("Radiology").build();
        specialtyService.save(radiology);

        Specialty surgery = Specialty.builder().description("Surgery").build();
        specialtyService.save(surgery);

        Specialty dentistry = Specialty.builder().description("Dentistry").build();
        specialtyService.save(dentistry);

        Owner owner1 = Owner.builder().firstName("Michael").lastName("Weston").address("123 Brick")
                .city("Gotham City").telephone("4242").build();

        Pet mikesPet = Pet.builder().petType(dog).owner(owner1).birth(LocalDate.now()).name("Bruce").build();
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brick");
        owner2.setCity("Gotham City");
        owner2.setTelephone("4242");

        Pet fionasCat = new Pet();
        fionasCat.setName("Cat Woman");
        fionasCat.setOwner(owner2);
        fionasCat.setBirth(LocalDate.now());
        fionasCat.setPetType(cat);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Snezzing");
        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(surgery);
        vet2.getSpecialties().add(dentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
