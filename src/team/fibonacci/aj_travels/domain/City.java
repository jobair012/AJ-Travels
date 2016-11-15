package team.fibonacci.aj_travels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class City extends CommonColumns {

	@Id
	@GeneratedValue
	private Long cityId;

	@Column(length = 20, nullable=false)
	@Size(min=3, max=20)
	private String cityName;

	@Column(length = 255)
	@Size(max=255)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="stateId")
	private State state;

	public City() {
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
