package team.fibonacci.aj_travels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Area extends CommonColumns {

	@Id
	@GeneratedValue
	private Long areaId;

	@Column(nullable=false, length = 20)
	@Size(min=3, max=20)
	private String areaName;

	@Column(length = 255)
	@Size(max=255)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="cityId")
	private City city;

	public Area() {
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
