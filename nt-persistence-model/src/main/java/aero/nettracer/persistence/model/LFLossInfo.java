package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="lflossinfo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LFLossInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3566745444509507964L;

	@Id
	@GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="loss_date")
	private Date lossdate;

	@Column(name="org_stn_code",length = 8)
	private String originStationCode;
	
	@Column(name="dest_stn_code",length = 8)
	private String destinationStationCode;
	
	@Column(name="agreement_num",length = 255)
	private String agreementNumber;
	
	@Column(name="mva_num",length = 32)
	private String mvaNumber;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public Date getLossdate() {
		return lossdate;
	}

	public void setLossdate(Date lossdate) {
		this.lossdate = lossdate;
	}
	
	public String getOriginStationCode() {
		return originStationCode;
	}

	public void setOriginStationCode(String originStationCode) {
		this.originStationCode = originStationCode;
	}

	public String getDestinationStationCode() {
		return destinationStationCode;
	}

	public void setDestinationStationCode(String destinationStationCode) {
		this.destinationStationCode = destinationStationCode;
	}
	
	public String getAgreementNumber() {
		return agreementNumber;
	}

	public void setAgreementNumber(String agreementNumber) {
		this.agreementNumber = agreementNumber;
	}

	public String getMvaNumber() {
		return mvaNumber;
	}

	public void setMvaNumber(String mvaNumber) {
		this.mvaNumber = mvaNumber;
	}
	
}
