package team.fibonacci.aj_travels.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CommonColumns {

	@Column(length = 45, updatable=false)
	protected String createdBy;

	@Column(updatable=false)
	protected Timestamp createdStamp;

	@Column(length = 45)
	protected String lastUpdatedBy;

	protected Timestamp lastUpdatedStamp;

	public CommonColumns() {
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Timestamp createdStamp) {
		this.createdStamp = createdStamp;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}

	public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}

}
