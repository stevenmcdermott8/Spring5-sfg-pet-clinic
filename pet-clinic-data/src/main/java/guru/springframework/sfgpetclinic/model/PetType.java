package guru.springframework.sfgpetclinic.model;

/**
 * stevmc created on 2/10/20
 */
public class PetType extends BaseEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
