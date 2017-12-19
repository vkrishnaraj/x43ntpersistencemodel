package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.persistence.model.fraudservice.detection.AccessRequest.RequestStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Set;

@Entity
@Table(name="fsfile")
public class File {

	private long id;
	private int statusId;
	private String companyCode;
	private Timestamp createDate;
	private int fraudstatusId;
	private Set<FsClaim> claims;
	private FsIncident incident;
	private HashMap<Long, Double> matchingFiles = null;
	private Set<Person> personCache = null;
	private Set<FsAddress> addressCache = null;
	private Set<Phone> phoneCache = null;
	private RequestStatus requestStatus;

	public File() {
	}

	public File(long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "statusid")
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Column(name = "company_code")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "fraudstatusid")
	public int getFraudStatusId() {
		return fraudstatusId;
	}

	public void setFraudStatusId(int fraudstatusId) {
		this.fraudstatusId = fraudstatusId;
	}

	@OneToMany(mappedBy = "file", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "claimdate")
	public Set<FsClaim> getClaims() {
		return claims;
	}

	public void setClaims(Set<FsClaim> claims) {
		this.claims = claims;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "file")
	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
	}

	@Transient
	public HashMap<Long, Double> getMatchingFiles() {
		return matchingFiles;
	}

	public void setMatchingFiles(HashMap<Long, Double> matchingFiles) {
		this.matchingFiles = matchingFiles;
	}

	@Transient
	public Set<Person> getPersonCache() {
		return personCache;
	}

	public void setPersonCache(Set<Person> personCache) {
		this.personCache = personCache;
	}

	@Transient
	public Set<FsAddress> getAddressCache() {
		return addressCache;
	}

	public void setAddressCache(Set<FsAddress> addressCache) {
		this.addressCache = addressCache;
	}

	@Transient
	public Set<Phone> getPhoneCache() {
		return phoneCache;
	}

	public void setPhoneCache(Set<Phone> phoneCache) {
		this.phoneCache = phoneCache;
	}

	@Transient
	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Transient
	public String getDisStatusText() {
		String toReturn;
		if (fraudstatusId == CommonsConstants.STATUS_SUSPECTED_FRAUD) {
			toReturn = "<p style=\"padding:0px;margin:0px;font-weight:bold;\">Suspected Fraud</p><br/>";
		} else if (fraudstatusId == CommonsConstants.STATUS_KNOWN_FRAUD) {
			toReturn = "<p style=\"padding:0px;margin:0px;font-weight:bold;\">Known Fraud</p><br/>";
		} else {
			toReturn = "";
		}
		return toReturn;
	}

	@Transient
	public String getDisStatus() {
		String toReturn;
		if (fraudstatusId == CommonsConstants.STATUS_SUSPECTED_FRAUD) {
			toReturn = "class=\"suspected_fraud\"";
		} else if (fraudstatusId == CommonsConstants.STATUS_KNOWN_FRAUD) {
			toReturn = "class=\"known_fraud\"";
		} else {
			toReturn = "";
		}
		return toReturn;
	}

	@Transient
	public FsClaim getFirstClaim() {
		if (claims != null && !claims.isEmpty()) {
			return claims.toArray(new FsClaim[0])[0];
		}
		return null;
	}
	public void resetCache() {
		this.addressCache = null;
		this.phoneCache = null;
		this.personCache = null;
	}

}
