package guru.springframework.sfgpetclinic.model;

/**
 * stevmc created on 2/15/20
 */
public class Specialty extends BaseEntity {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
