package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * stevmc created on 2/14/20
 */
@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;

	private final VetService vetService;

	private final PetTypeService petTypeService;

	private final SpecialtyService specialtyService;

	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int countPetTypes = petTypeService.findAll().size();
		if (countPetTypes == 0) {
			System.out.println("No Current Data, Loading Data.....");
			loadData();
			System.out.println("Loaded Data.....");
		}
	}

	private void loadData() {
		System.out.println("Loading Pet Types.....");
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		System.out.println("Loaded Pet Types.....");

		System.out.println("Loading Specialties.....");
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedSurgery = specialtyService.save(surgery);

		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry);

		System.out.println("Loaded Specialties.....");

		System.out.println("Loading Owners and Pets.....");
		Owner owner = new Owner();
		owner.setFirstName("Steven");
		owner.setLastName("McDermott");
		owner.setAddress("123 Main St");
		owner.setCity("Fair Oaks");
		owner.setTelephone("555-555-5555");

		Pet stevensPet = new Pet();
		stevensPet.setPetType(savedDogPetType);
		stevensPet.setOwner(owner);
		stevensPet.setName("Bubba");
		stevensPet.setBirthDate(LocalDate.of(2015, 05, 15));
		owner.getPets().add(stevensPet);

		ownerService.save(owner);

		Visit dogVisit = new Visit();
		dogVisit.setPet(stevensPet);
		dogVisit.setDescription("Stomach Bug");
		dogVisit.setDate(LocalDate.now());

		visitService.save(dogVisit);

		Owner owner2 = new Owner();
		owner2.setFirstName("Jeanette");
		owner2.setLastName("Martinez");
		owner2.setAddress("456 Main St");
		owner2.setCity("Sacramento");
		owner2.setTelephone("555-555-1234");

		Pet jeanettesPet = new Pet();
		jeanettesPet.setPetType(savedCatPetType);
		jeanettesPet.setOwner(owner2);
		jeanettesPet.setName("Kona");
		stevensPet.setBirthDate(LocalDate.of(2017, 01, 15));
		owner2.getPets().add(jeanettesPet);

		ownerService.save(owner2);

		System.out.println("Loaded Owners and Pets.....");

		System.out.println("Loading Vets.....");
		Vet vet = new Vet();
		vet.setFirstName("Tom");
		vet.setLastName("Sawyer");
		vet.getSpecialties().add(savedRadiology);
		vet.getSpecialties().add(savedDentistry);

		vetService.save(vet);

		Vet vet2 = new Vet();
		vet2.setFirstName("Abraham");
		vet2.setLastName("Lincoln");
		vet2.getSpecialties().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets.....");
	}
}
