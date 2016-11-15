package team.fibonacci.aj_travels.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Party extends CommonColumns {

	@Id
	@GeneratedValue
	private Long partyId;

	@Column(nullable = false, length = 45)
	@Size(min=3, max=45)
	private String partyName;

	@ManyToOne
	@JoinColumn(name="partyTypeId", nullable=false)
	@Valid
	private PartyType partyType;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "party")
	@JsonIgnore
	@Valid
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Party() {
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public PartyType getPartyType() {
		return partyType;
	}

	public void setPartyType(PartyType partyType) {
		this.partyType = partyType;
	}

}
