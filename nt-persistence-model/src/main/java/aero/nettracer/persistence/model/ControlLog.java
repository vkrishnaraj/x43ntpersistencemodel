package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ListIterator;

import com.cci.utils.parser.ElementNode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "file_control")
public class ControlLog implements Serializable {

	private int control_id;
	private String start_date;
	private String end_date;
	private Station controlling_station;
	
	private OHD ohd;

	@Id
	@GeneratedValue
	public int getControl_id() {
		return control_id;
	}

	public void setControl_id(int control_id) {
		this.control_id = control_id;
	}

	@ManyToOne
	@JoinColumn(name = "file_ref_number")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	@ManyToOne
	@JoinColumn(name = "controlling_station_id")
	public Station getControlling_station() {
		return controlling_station;
	}

	public void setControlling_station(Station controlling_station) {
		this.controlling_station = controlling_station;
	}
	
	public String toXML() {
		StringBuffer ret = new StringBuffer(1096);
		
		ret.append("<control_log>");
		ret.append("<control_id>" + control_id + "</control_id>");
		ret.append("<file_ref_number>" + ohd.getOHD_ID() + "</file_ref_number>");
		ret.append("<start_date>" + start_date + "</start_date>");
		ret.append("<end_date>" + end_date + "</end_date>");
		ret.append("<controlling_station_id>" + controlling_station + "</controlling_station_id>");
		ret.append("</control_log>");
		
		
		return ret.toString();
	}
	
	public static ControlLog XMLtoObject(ElementNode root) {
		ControlLog obj = new ControlLog();

	
		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;
		
		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("control_id")) {
				obj.setControl_id(parseInt(child.getTextContents()));
			}else if (child.getType().equals("file_ref_number")) {
				OHD ohd = new OHD();
				ohd.setOHD_ID(child.getTextContents());
				obj.setOhd(ohd);
			}else if (child.getType().equals("start_date")) {
				obj.setStart_date(child.getTextContents());
			}else if (child.getType().equals("end_date")) {
				obj.setEnd_date(child.getTextContents());
			}else if (child.getType().equals("controlling_station_id")) {
				Station s = new Station();
				s.setStation_ID(parseInt(child.getTextContents()));
				
				obj.setControlling_station(s);
			}
		}
		
		return obj;
	}

	public static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

	public static double parseDouble(String s) {
		try {
			return Double.parseDouble(s);
		} catch (Exception e) {
			return 0;
		}
	}
}