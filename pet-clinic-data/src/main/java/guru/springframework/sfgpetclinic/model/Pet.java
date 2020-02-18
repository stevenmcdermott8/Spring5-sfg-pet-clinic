package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * stevmc created on 2/10/20
 */
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;

	@Column(name = "birth_date") private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@Column(name = "name") private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet") private Set<Visit> visits = new HashSet<>();

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

	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
}
