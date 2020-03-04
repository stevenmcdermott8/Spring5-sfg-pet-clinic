package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	String lastName = "Smith";
	Owner returnOwner;

	@Mock OwnerRepository ownerRepository;

	@InjectMocks OwnerSDJpaService service;

	@BeforeEach
	void setUp() {
		returnOwner = Owner.builder().id(1L).lastName(lastName).build();
	}

	@Test
	void findByLastName() {

		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

		Owner smith = service.findByLastName(lastName);

		assertNotNull(smith);
		assertEquals(1L, returnOwner.getId());
		assertEquals(lastName, returnOwner.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

	@Test
	void findAll() {
		Set<Owner> returnedOwnerSet = new HashSet<>();
		returnedOwnerSet.add(Owner.builder().id((1L)).build());
		returnedOwnerSet.add(Owner.builder().id((2L)).build());
		when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);
		Set<Owner> owners = service.findAll();
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	void findById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = service.findById(1L);
		assertNotNull(owner);
	}

	@Test
	void findByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = service.findById(1L);
		assertNull(owner);
	}

	@Test
	void save() {
		Owner ownerToSave = Owner.builder().id(1L).build();
		when(ownerRepository.save(any())).thenReturn(ownerToSave);
		Owner savedOwner = service.save(ownerToSave);
		assertNotNull(savedOwner);
		verify(ownerRepository).save(any());
	}

	@Test
	void delete() {
		service.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}

	@Test
	void deleteById() {
		service.deleteById(anyLong());
		verify(ownerRepository).deleteById(anyLong());
	}
}