package team.fibonacci.aj_travels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
@Entity
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
public class UserDetail extends CommonColumns{

	@Id
	@Column(length = 20)
	@Size(min=3, max=20)
	private String username;

	@Column(nullable = false, length = 45)
	@Size(min=3, max=45)
	private String name;

	@Column(nullable = false, length = 45)
	@Email
	@NotBlank
	private String email;

	@Column(nullable = false, length = 45)
	@NotBlank
	private String phoneNo;

	public UserDetail() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
