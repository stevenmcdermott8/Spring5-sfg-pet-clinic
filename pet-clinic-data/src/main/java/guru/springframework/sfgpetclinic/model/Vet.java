package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * stevmc created on 2/10/20
 */
public class Vet extends Person {

	private Set<Specialty> specialties;

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
}
