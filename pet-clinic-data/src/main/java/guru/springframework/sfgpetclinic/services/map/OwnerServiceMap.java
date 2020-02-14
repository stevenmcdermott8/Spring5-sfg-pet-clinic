package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

import java.util.Set;

/**
 * stevmc created on 2/11/20
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Owner object) {
		super.deleteByObject(object);
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}
}
