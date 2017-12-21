package aero.nettracer.persistence.model.wt;

import aero.nettracer.persistence.model.Worldtracer_Actionfiles.ActionFileType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Iterator;

@Embeddable
@Table(name = "actionfile_station_counts")
public class ActionFileCount implements Iterable<Integer>, Comparable<ActionFileCount> {

	private int dayFive;
	private boolean dayFiveLoaded;
	private int dayFour;
	private boolean dayFourLoaded;
	private int dayOne;
	private boolean dayOneLoaded;
	private int daySeven;
	private boolean daySevenLoaded;
	private int daySix;
	private boolean daySixLoaded;
	private int dayThree;
	private boolean dayThreeLoaded;
	private int dayTwo;
	private boolean dayTwoLoaded;
	private ActionFileType af_type;
	private String af_seq;



	public ActionFileCount(){
	}
	
	public ActionFileCount(ActionFileType type){
		this.af_type = type;
		this.af_seq = "";
	}

	@Column(name = "dayfive")
	public int getDayFive() {
		return dayFive;
	}

	public void setDayFive(int dayFive) {
		this.dayFive = dayFive;
	}

	@Column(name = "dayfiveloaded")
	public boolean isDayFiveLoaded() {
		return dayFiveLoaded;
	}

	public void setDayFiveLoaded(boolean dayFiveLoaded) {
		this.dayFiveLoaded = dayFiveLoaded;
	}

	@Column(name = "dayfour")
	public int getDayFour() {
		return dayFour;
	}

	public void setDayFour(int dayFour) {
		this.dayFour = dayFour;
	}

	@Column(name = "dayfourloaded")
	public boolean isDayFourLoaded() {
		return dayFourLoaded;
	}

	public void setDayFourLoaded(boolean dayFourLoaded) {
		this.dayFourLoaded = dayFourLoaded;
	}

	@Column(name = "dayone")
	public int getDayOne() {
		return dayOne;
	}

	public void setDayOne(int dayOne) {
		this.dayOne = dayOne;
	}

	@Column(name = "dayoneloaded")
	public boolean isDayOneLoaded() {
		return dayOneLoaded;
	}

	public void setDayOneLoaded(boolean dayOneLoaded) {
		this.dayOneLoaded = dayOneLoaded;
	}

	@Column(name = "dayseven")
	public int getDaySeven() {
		return daySeven;
	}

	public void setDaySeven(int daySeven) {
		this.daySeven = daySeven;
	}

	@Column(name = "daysevenloaded")
	public boolean isDaySevenLoaded() {
		return daySevenLoaded;
	}

	public void setDaySevenLoaded(boolean daySevenLoaded) {
		this.daySevenLoaded = daySevenLoaded;
	}

	@Column(name = "daysix")
	public int getDaySix() {
		return daySix;
	}

	public void setDaySix(int daySix) {
		this.daySix = daySix;
	}

	@Column(name = "daysixloaded")
	public boolean isDaySixLoaded() {
		return daySixLoaded;
	}

	public void setDaySixLoaded(boolean daySixLoaded) {
		this.daySixLoaded = daySixLoaded;
	}

	@Column(name = "daythree")
	public int getDayThree() {
		return dayThree;
	}

	public void setDayThree(int dayThree) {
		this.dayThree = dayThree;
	}

	@Column(name = "daythreeloaded")
	public boolean isDayThreeLoaded() {
		return dayThreeLoaded;
	}

	public void setDayThreeLoaded(boolean dayThreeLoaded) {
		this.dayThreeLoaded = dayThreeLoaded;
	}

	@Column(name = "daytwo")
	public int getDayTwo() {
		return dayTwo;
	}

	public void setDayTwo(int dayTwo) {
		this.dayTwo = dayTwo;
	}

	@Column(name = "daytwoloaded")
	public boolean isDayTwoLoaded() {
		return dayTwoLoaded;
	}

	public void setDayTwoLoaded(boolean dayTwoLoaded) {
		this.dayTwoLoaded = dayTwoLoaded;
	}

	@Enumerated(EnumType.STRING)
	public ActionFileType getAf_type() {
		return af_type;
	}

	public void setAf_type(ActionFileType afType) {
		af_type = afType;
	}

	public String getAf_seq() {
		return af_seq;
	}

	public void setAf_seq(String afSeq) {
		af_seq = afSeq;
	}

	public Iterator<Integer> iterator() {
		return Arrays.asList(dayOne, dayTwo, dayThree, dayFour, dayFive, daySix, daySeven).iterator();
	}
	
	public int compareTo(ActionFileCount afc){
		int type_order = this.af_type.compareTo(afc.getAf_type());
		if (type_order != 0){
			return type_order;
		} else {
			return this.af_seq.compareTo(afc.getAf_seq());
		}

	}

}
