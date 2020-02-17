package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * stevmc created on 2/15/20
 */
@Entity
@Table(name = "specialities")
public class Specialty extends BaseEntity {

	@Column(name = "description") private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
