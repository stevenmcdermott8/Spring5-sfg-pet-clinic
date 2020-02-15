package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

/**
 * stevmc created on 2/10/20
 */
public class Pet extends BaseEntity {

	private PetType petType;
	private LocalDate birthDate;
	private Owner owner;
	private String name;

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
