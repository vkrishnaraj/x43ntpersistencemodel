package aero.nettracer.persistence.model.documents;

import aero.nettracer.persistence.model.documents.templates.Template;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document {
	
	private long id;
	private Template template;
	private String content;
	private String title;
	private String fileName;
	private String marginTop;
	private String marginBottom;
	private String marginLeft;
	private String marginRight;
	
	public Document() { }
	
	public Document(Template template) {
		this.template = template;
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

	@ManyToOne
	@JoinColumn(name = "templateId")
	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "filename")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "margintop")
	public String getMarginTop() {
		return marginTop;
	}

	public void setMarginTop(String marginTop) {
		this.marginTop = marginTop;
	}

	@Column(name = "marginbottom")
	public String getMarginBottom() {
		return marginBottom;
	}

	public void setMarginBottom(String marginBottom) {
		this.marginBottom = marginBottom;
	}

	@Column(name = "marginleft")
	public String getMarginLeft() {
		return marginLeft;
	}

	public void setMarginLeft(String marginLeft) {
		this.marginLeft = marginLeft;
	}

	@Column(name = "marginright")
	public String getMarginRight() {
		return marginRight;
	}

	public void setMarginRight(String marginRight) {
		this.marginRight = marginRight;
	}

	public String getName() {
		if (template != null) {
			return template.getName();
		}
		return "";
	}

	public String getMarginHeader() {
		StringBuilder margins = new StringBuilder(getMarginTop() + "in ");
		margins.append(getMarginRight() + "in ");
		margins.append(getMarginBottom() + "in ");
		margins.append(getMarginLeft() + "in");
		String toReturn = "<head>" +
		"		<style type=\"text/css\" media=\"print\">" +
		"			@page " +
		"			{" +
		"				size: auto;   /* auto is the current printer page size */" +
		"				margin: " + margins.toString() + ";  /* this affects the margin in the printer settings */" +
		"			}" +
		"			body" +
		"			{ " +
		"				/* this affects the margin on the content before sending to printer */" +
		"				margin: 0px;  " +
		"			} " +
		"		</style>" +
		"</head>";
		return toReturn;
	}
	
	public String getHTMLPrintContent() {
		StringBuilder printContent = new StringBuilder("<html>" + getMarginHeader() + "<body>");
		printContent.append(getContent());
		printContent.append("</body></html>");
		return printContent.toString();
	}
	
	public void appendContent(Document toAppend) {
		if (toAppend == null || toAppend.getContent() == null || StringUtils.isBlank(toAppend.getContent())) return;
		StringBuilder newContent = new StringBuilder(getContent() != null ? getContent() : "");
		newContent.append("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
		newContent.append(toAppend.getContent());
		this.setContent(newContent.toString());
	}

}
