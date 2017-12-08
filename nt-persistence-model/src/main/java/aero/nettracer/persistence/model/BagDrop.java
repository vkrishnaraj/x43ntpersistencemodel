package aero.nettracer.persistence.model;

import java.util.Date;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class BagDrop {

	private long id;
	private Date createDate;
	private Date lastUpdated;
	private String arrivalStationCode;
	private String originStationCode;
	
	private String airline;
	private String flight;
	
	private int entryMethod;
	private Date bagDropTime;
	
	private Date schArrivalDate;
	private Date actArrivalDate;
	

	private Agent createAgent;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@ManyToOne
	@JoinColumn(name = "createAgent_ID", nullable = true)
	public Agent getCreateAgent() {
		return createAgent;
	}
	public void setCreateAgent(Agent createAgent) {
		this.createAgent = createAgent;
	}
	public int getEntryMethod() {
		return entryMethod;
	}
	public void setEntryMethod(int entryMethod) {
		this.entryMethod = entryMethod;
	}
	public Date getBagDropTime() {
		return bagDropTime;
	}
	public void setBagDropTime(Date bagDropTime) {
		this.bagDropTime = bagDropTime;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Date getSchArrivalDate() {
		return schArrivalDate;
	}
	public void setSchArrivalDate(Date schArrivalDate) {
		this.schArrivalDate = schArrivalDate;
	}
	public Date getActArrivalDate() {
		return actArrivalDate;
	}
	public void setActArrivalDate(Date actArrivalDate) {
		this.actArrivalDate = actArrivalDate;
	}
	public String getArrivalStationCode() {
		return arrivalStationCode;
	}
	public void setArrivalStationCode(String arrivalStationCode) {
		this.arrivalStationCode = arrivalStationCode;
	}
	public String getOriginStationCode() {
		return originStationCode;
	}
	public void setOriginStationCode(String originStationCode) {
		this.originStationCode = originStationCode;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}

	@Transient
	public String getDispTimeToCarousel(){
		if(bagDropTime == null || (actArrivalDate == null && schArrivalDate == null)){
			return "";
		}
		
		long time = getTimeToCarousel();
		long absTime = Math.abs(time);
		
		long mins = absTime%60;
		long hours = absTime/60;

		String retString = "";
		if(time < 0){
			retString = "-";
		}
		return retString + String.format("%02d:%02d", hours, mins);
	}

	@Transient
	public long getTimeToCarousel(){
		if(bagDropTime == null || (actArrivalDate == null && schArrivalDate == null)){
			return 0;
		}
		
		long arrivalTime = actArrivalDate!=null?actArrivalDate.getTime():schArrivalDate.getTime();
		
		return (bagDropTime.getTime() - arrivalTime)/60000;
	}
	
	
	/**
	 * The boolean set to true while updating a bagdrop if a previous bagdrop time existed
	 */
	private boolean previouslyEntered;

	@Transient
	public boolean isPreviouslyEntered() {
		return previouslyEntered;
	}
	public void setPreviouslyEntered(boolean previouslyEntered) {
		this.previouslyEntered = previouslyEntered;
	}
	
	
	/**
	 * ************************************************
	 * The following are for date/time display purposes
	 * ************************************************
	 */
	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private java.util.TimeZone _TIMEZONE;
	private String sbagDropDate;
	private String sbagDropTime;

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}
	public void set_DATEFORMAT(String _DATEFORMAT) {
		this._DATEFORMAT = _DATEFORMAT;
	}

	@Transient
	public String get_TIMEFORMAT() {
		return _TIMEFORMAT;
	}
	public void set_TIMEFORMAT(String _TIMEFORMAT) {
		this._TIMEFORMAT = _TIMEFORMAT;
	}

	@Transient
	public java.util.TimeZone get_TIMEZONE() {
		return _TIMEZONE;
	}
	public void set_TIMEZONE(java.util.TimeZone _TIMEZONE) {
		this._TIMEZONE = _TIMEZONE;
	}

	@Transient
	public String getDispSchArrivalDateTime(){
		String s = GenericDateUtils.formatDate(getSchArrivalDate(), _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
		return s!=null?s:"";
	}
	@Transient
	public String getDispBagDropDateTime() {
		String s = GenericDateUtils.formatDate(getBagDropTime(), _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
		return s!=null?s:"";
	}

	@Transient
	public String getDispActArrivalDateTime(){
		String s = GenericDateUtils.formatDate(getActArrivalDate(), _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
		return s!=null?s:"";
	}

	@Transient
	public String getDispBagDropDate(){
		return GenericDateUtils.formatDate(getBagDropTime(), _DATEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public String getDispBagDropTime(){
		return GenericDateUtils.formatDate(getBagDropTime(), _TIMEFORMAT, null, _TIMEZONE);
	}
	
	public void setDispBagDropDate(String date){
		sbagDropDate = date;
		updateBagDropDateTime();
	}
	
	public void setDispBagDropTime(String time){
		sbagDropTime = time;
		updateBagDropDateTime();
	}
	
	private void updateBagDropDateTime(){
		if(sbagDropDate != null && sbagDropDate.trim().length()>0
				&& sbagDropTime != null && sbagDropTime.trim().length()>0){
			Date d = GenericDateUtils.convertToDate(sbagDropDate + " " + sbagDropTime, _DATEFORMAT + " " +_TIMEFORMAT, null, _TIMEZONE);
			setBagDropTime(GenericDateUtils.convertToGMTDate(d));
			sbagDropTime=null;
			sbagDropDate=null;
		}
	}

}
