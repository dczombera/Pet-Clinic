package czombera.dennis.petclinic.bootstrap;

import czombera.dennis.petclinic.model.*;
import czombera.dennis.petclinic.services.OwnerService;
import czombera.dennis.petclinic.services.PetTypeService;
import czombera.dennis.petclinic.services.SpecialtyService;
import czombera.dennis.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brick");
        owner1.setCity("Gotham City");
        owner1.setTelephone("4242");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setOwner(owner1);
        mikesPet.setBirth(LocalDate.now());
        mikesPet.setName("Bruce");
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
