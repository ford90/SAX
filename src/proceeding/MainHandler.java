package proceeding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class MainHandler extends DefaultHandler {
	
	private Stack<String>	elementStack 			= new Stack<String>();
	private Stack<Object> 	objectStack 			= new Stack<Object>();
	
	public List<ProceedingRec> procRecs				= new ArrayList<ProceedingRec>();
	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		this.elementStack.push(qName);
		if(qName.equalsIgnoreCase("proceeding_rec")){
			ProceedingRec procRec = new ProceedingRec();
			this.objectStack.push(procRec);
		} else if(qName.equalsIgnoreCase("ch_ed")) {
			Editor editor = new Editor();
			this.objectStack.push(editor);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
		throws SAXException{
		this.elementStack.pop();
		if(qName.equalsIgnoreCase("proceeding_rec")){
			ProceedingRec procRec = (ProceedingRec) this.objectStack.pop();
			procRecs.add(procRec);
		} else if(qName.equalsIgnoreCase("ch_ed")) {
			Editor editor = (Editor) this.objectStack.pop();
			ProceedingRec procRec = (ProceedingRec) this.objectStack.peek();
			procRec.addEditor(editor);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		String value = new String(ch, start, length);
		if(value.length()==0) {
			return;
		}
//		System.out.println(value + " : " +
//		 currentElement() +
//		" : " + currentParentElement());
		if( currentElement().equals("proc_id") &&
				currentParentElement().equals("proceeding_rec")) {
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			// Add checks when move it to ProceedingRecHandler
			procRec.setProdId(value);
		} else if( currentElement().equals("acronym") &&
				currentParentElement().equals("proceeding_rec")) {
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			procRec.setAcronym(value);
		} else if( currentElement().equals("proc_desc") &&
				currentParentElement().equals("proceeding_rec")) {
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			procRec.setProcDesc(value);
		} else if( currentElement().equals("proc_class") &&
				currentParentElement().equals("proceeding_rec") ) {
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			procRec.setProcClass(value);
		} else if( currentElement().equals("proc_title") &&
				currentParentElement().equals("proceeding_rec") ){
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			procRec.setProcTitle(value);
		} else if( currentElement().equals("isbn") &&
				currentParentElement().equals("proceeding_rec") ){
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			procRec.setIsbn(value);
		} else if( currentElement().equals("proc_volume_no") &&
				currentParentElement().equals("proceeding_rec")) {
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			procRec.setProcVolume(value);
		} else if( currentElement().equals("copyright_year") && 
				currentParentElement().equals("proceeding_rec")) {
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			procRec.setCopyYear(value);
		} else if( currentElement().equals("publication_date") &&
				currentParentElement().equals("proceeding_rec")) {
			ProceedingRec procRec = (ProceedingRec)this.objectStack.peek();
			procRec.setPubDate(value);
		} else if( currentElement().equals("seq_no") && 
				currentParentElement().equals("ch_ed")) {
			Editor editor = (Editor) this.objectStack.peek();
			editor.setSeqNo(new Integer(value));
		} else if( currentElement().equals("first_name") &&
				currentParentElement().equals("ch_ed")) {
			Editor editor = (Editor) this.objectStack.peek();
			editor.setFirstName(value);
		} else if( currentElement().equals("last_name") &&
				currentParentElement().equals("ch_ed") ) {
			Editor editor = (Editor) this.objectStack.peek();
			editor.setLastName(value);
		} else if( currentElement().equals("affiliation") &&
				currentParentElement().equals("ch_ed") ) {
			Editor editor = (Editor) this.objectStack.peek();
			editor.setAffil(value);
		} else if( currentElement().equals("email_address") && 
				currentParentElement().equals("ch_ed")) {
			Editor editor = (Editor) this.objectStack.peek();
			editor.setEmail(value);
		}
		
		
		
	}

	private String currentElement() {
		return this.elementStack.peek();
	}
	
	private String currentParentElement() {
		if(this.elementStack.size() < 2)
			return null;
		else
			return this.elementStack.get(this.elementStack.size()-2);
	}
}
