package aero.nettracer.persistence.model.datafeed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@NamedQueries({
	@NamedQuery(
	name = "alreadyProcessedByType",
	query = "from DataFeedLog where fileDate >= :fileDate and dataType = :feedType and companyCode = :companycode_ID"
	)
	})
@Entity
@Table(name="z_ws_data_feed_log")
public class DataFeedLog {
	
	public static final String ALREADY_PROCESSED_BY_TYPE = "alreadyProcessedByType";
	
	public static final String FAIL = "FAIL";
	public static final String SUCCESS = "SUCCESS";
	
	public enum DataType {
		FLIGHT_INFO,
	}
	
	private long id;
	private String companyCode;
	private DataType dataType;
	private Timestamp fileDate;
	private String fileName;
	private Timestamp importDate;
	private long numRows;
	private String result;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="companycode_id")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String company) {
		this.companyCode = company;
	}

	@Column(name="data_type")
	@Enumerated(EnumType.STRING)
	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	@Column(name="flight_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getFileDate() {
		return fileDate;
	}

	public void setFileDate(Timestamp fileDate) {
		this.fileDate = fileDate;
	}

	@Column(name="file_name")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="import_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getImportDate() {
		return importDate;
	}

	public void setImportDate(Timestamp importDate) {
		this.importDate = importDate;
	}

	@Column(name="num_rows")
	public long getNumRows() {
		return numRows;
	}

	public void setNumRows(long numRows) {
		this.numRows = numRows;
	}

	@Column(name="result")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
