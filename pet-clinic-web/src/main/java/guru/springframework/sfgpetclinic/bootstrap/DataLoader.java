package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * stevmc created on 2/14/20
 */
@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;

	private final VetService vetService;

	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Loading Owners.....");
		Owner owner = new Owner();
		owner.setId(1L);
		owner.setFirstName("Steven");
		owner.setLastName("McDermott");
		ownerService.save(owner);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Jeanette");
		owner2.setLastName("Martinez");
		ownerService.save(owner2);
		System.out.println("Loaded Owners.....");

		System.out.println("Loading Vets.....");
		Vet vet = new Vet();
		vet.setId(1L);
		vet.setFirstName("Tom");
		vet.setLastName("Sawyer");

		vetService.save(vet);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Abraham");
		vet2.setLastName("Lincoln");

		vetService.save(vet2);

		System.out.println("Loaded Vets.....");
	}
}
