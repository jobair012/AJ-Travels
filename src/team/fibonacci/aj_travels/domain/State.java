package team.fibonacci.aj_travels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class State extends CommonColumns {

	@Id
	@GeneratedValue
	private Long stateId;

	@Column(length = 20, nullable=false)
	@Size(min=3, max=20)
	private String stateName;

	@Column(length = 255)
	@Size(max=255)
	private String description;

	@ManyToOne
	@JoinColumn(name = "countryId")
	private Country country;

	public State() {
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
