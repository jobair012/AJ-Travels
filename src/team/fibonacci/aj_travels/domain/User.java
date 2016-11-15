package team.fibonacci.aj_travels.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.stereotype.Component;

@Component
@Entity
@DynamicUpdate
@SelectBeforeUpdate
public class User extends CommonColumns {

	@Id
	@Column(length = 20)
	@Size(min = 3, max = 20)
	private String username;

	@Column(nullable = false)
	@Size(min = 3, max = 20)
	private String password;

	@Column(nullable = false)
	@NotNull
	private Boolean enabled;

	@ManyToOne
	@JoinColumn(name = "role")
	@Valid
	private UserRole userRole;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@Valid
	private UserDetail userDetail;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}
