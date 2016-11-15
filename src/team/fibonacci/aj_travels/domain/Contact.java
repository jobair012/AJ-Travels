package team.fibonacci.aj_travels.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Contact extends CommonColumns {

	@Id
	@GeneratedValue
	private Long contactId;

	@Column(length = 125)
	@Size(max=125)
	private String address;

	@Column(length = 255)
	@Size(max=255)
	private String description;

	@Column(length = 45)
	@Size(max=45)
	private String phoneNo;

	@Column(length = 45)
	@Size(max=45)
	private String website;

	@Column(length = 45)
	@Size(max=45)
	private String fax;

	@Column(length = 45)
	@Size(max=45)
	@Email
	private String email;
	
	@Column(length = 20)
	@Size(max=20)
	private String postralCode;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "partyId")
	private Party party;

	@ManyToOne
	@JoinColumn(name = "areaId")
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "cityId")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "stateId")
	private State state;
	
	@ManyToOne
	@JoinColumn(name = "countryId")
	private Country country;

	public String getPostralCode() {
		return postralCode;
	}

	public void setPostralCode(String postralCode) {
		this.postralCode = postralCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Contact() {
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
