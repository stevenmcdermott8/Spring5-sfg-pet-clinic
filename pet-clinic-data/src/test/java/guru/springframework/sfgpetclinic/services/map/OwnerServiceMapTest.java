package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	long ownerId = 1L;
	long ownerId2 = 2L;
	String lastName = "McDermott";

	@BeforeEach
	void setUp() {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void findAll() {
		Set<Owner> owners = ownerServiceMap.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void deleteById() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void saveExistingId() {
		Owner owner2 = Owner.builder().id(ownerId2).build();
		Owner savedOwner = ownerServiceMap.save(owner2);
		assertEquals(ownerId2, savedOwner.getId());
	}

	@Test
	void saveNoId() {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void delete() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void findById() {
		Owner owner = ownerServiceMap.findById(1L);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void findByLastName() {
		Owner owner = ownerServiceMap.findByLastName(lastName);
		assertNotNull(owner);
		assertEquals(1L, owner.getId());
		assertEquals(lastName, owner.getLastName());
	}
}