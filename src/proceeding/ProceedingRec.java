package proceeding;

import java.util.ArrayList;
import java.util.List;

public class ProceedingRec {
	private String 			procId;
	private String 			acronym;
	private String 			procDesc;
	private String 			procClass;
	private String 			procTitle;
	private String 			procSubtitle;
	private String 			procVolume;
	private String 			isbn;
	private String 			copyYear;
	private String 			pubDate;
	private List<Editor>	editors	= new ArrayList<Editor>();
	
	public String getProcId() {
		return procId;
	}
	
	public void setProdId(String procId) {
		this.procId = procId;
	}
	
	public String getAcronym() {
		return acronym;
	}
	
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public String getProcDesc() {
		return procDesc;
	}
	
	public void setProcDesc(String procDesc) {
		this.procDesc = procDesc;
	}
	
	public String getProcClass() {
		return procClass;
	}
	
	public void setProcClass(String procClass) {
		this.procClass = procClass;
	}
	
	public String getProcTitle() {
		return procTitle;
	}
	
	public void setProcTitle(String procTitle) {
		this.procTitle = procTitle;
	}
	
	public String getProcSubtitle() {
		return procSubtitle;
	}
	
	public void setProcSubtitle(String procSubtitle) {
		this.procSubtitle = procSubtitle;
	}
	
	public String getProcVolume() {
		return procVolume;
	}
	
	public void setProcVolume(String procVolume) {
		this.procVolume = procVolume;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getCopyYear() {
		return copyYear;
	}
	
	public void setCopyYear(String copyYear) {
		this.copyYear = copyYear;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	public List<Editor> getEditors() {
		return editors;
	}
	
	public void setEditors(List editors) {
		this.editors = editors;
	}
	
	public void addEditor(Editor editor) {
		this.editors.add(editor);
	}
	
	public String toString() {
		return    "id            : " + procId + "\n"
				+ "acronym       : " + acronym + "\n"
				+ "procDesc      : " + procDesc + "\n"
				+ "procClass     : " + procClass + "\n"
				+ "procTitle     : " + procTitle + "\n"
				+ "procVolume    : " + procVolume + "\n"
				+ "Isbn          : " + isbn + "\n"
				+ "copyYear      : " + copyYear + "\n"
				+ "pubDate       : " + pubDate + "\n"
				+ "editors       : " + editors;
	}
	
}
