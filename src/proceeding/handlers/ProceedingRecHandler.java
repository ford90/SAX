package proceeding.handlers;

import java.io.CharArrayWriter;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import proceeding.Editor;
import proceeding.Printable;
import proceeding.ProceedingRec;

public class ProceedingRecHandler extends DefaultHandler{

	private XMLReader 		parser;
	private ProceedingRec	procRec;
	private ContentHandler 	parent;
	private CharArrayWriter contents = new CharArrayWriter();
	
	public void read(XMLReader parser, ContentHandler parent, ProceedingRec procRec) {
		this.parser 	= parser;
		this.parent 	= parent;
		this.procRec 	= procRec;
		// Change parser handler on the fly to this current so now 
		this.parser.setContentHandler(this);
		System.out.println("Inside proceedingRec Handler");
	}
	
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes attr) {
		contents.reset();
		if(qName.equals("ch_ed")) {
			Editor 			editor 			= new Editor();
			EditorHandler 	editorHandler	= new EditorHandler();
			editorHandler.read(parser, this, editor);
		}
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName) {
		// Add logic here for ProceedingRec
		if(qName.equals("proc_id")) {
			procRec.setProdId(contents.toString());
		} else if(qName.equals("acronym")) {
			procRec.setAcronym(contents.toString());
		} else if(qName.equals("proc_desc")) {
			procRec.setProcDesc(contents.toString());
		} else if(qName.equals("proc_class")) {
			procRec.setProcClass(contents.toString());
		} else if(qName.equals("proc_title")) {
			procRec.setProcTitle(contents.toString());
		} else if(qName.equals("proc_volume_no")) {
			procRec.setProcVolume(contents.toString());
		} else if(qName.equals("copyright_year")) {
			procRec.setCopyYear(contents.toString());
		} else if(qName.equals("publication_date")) {
			procRec.setPubDate(contents.toString());
		} else if(qName.equals("proceeding_rec")) {
			parser.setContentHandler(parent);
			System.out.println(this.procRec);
			Printable.listOfObjects.add(procRec);
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) {
		contents.write(ch, start, length);
	}
}
