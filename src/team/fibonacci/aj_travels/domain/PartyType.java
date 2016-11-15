package team.fibonacci.aj_travels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class PartyType extends CommonColumns{

	@Id
	@GeneratedValue
	private Long partyTypeId;

	@Column(length = 20, nullable=false)
	@Size(min=3, max=20)
	private String partyTypeName;

	@Column(length = 255)
	@Size(max=255)
	private String description;
	
//	@OneToMany(cascade=CascadeType.ALL , mappedBy="partyType")
//	private List<Party> party;

	public PartyType() {
	}

	public Long getPartyTypeId() {
		return partyTypeId;
	}

	public void setPartyTypeId(Long partyTypeId) {
		this.partyTypeId = partyTypeId;
	}

	public String getPartyTypeName() {
		return partyTypeName;
	}

	public void setPartyTypeName(String partyTypeName) {
		this.partyTypeName = partyTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<Party> getParty() {
//		return party;
//	}
//
//	public void setParty(List<Party> party) {
//		this.party = party;
//	}
	
}
