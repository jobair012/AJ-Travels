package team.fibonacci.aj_travels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
@Entity
public class UserRole extends CommonColumns {

	@Id
	@Column(nullable = false, length = 20)
	@NotBlank
	private String role;

	@Column(length = 255)
	@Size(max=255)
	private String description;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole")
//	private List<User> user;

	public UserRole() {
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<User> getUser() {
//		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}

}
