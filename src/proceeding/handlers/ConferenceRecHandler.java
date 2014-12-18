package proceeding.handlers;

import java.io.CharArrayWriter;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import proceeding.ConferenceRec;

public class ConferenceRecHandler extends DefaultHandler{
	
	private XMLReader 		parser;
	private ContentHandler 	parent;
	private ConferenceRec	confRec;
	private CharArrayWriter	contents = new CharArrayWriter();
	
	// Why not use a public Constructor??
	public void read(XMLReader parser, ContentHandler parent, ConferenceRec confRec) {
		this.parser 	= parser;
		this.parent 	= parent;
		this.confRec 	= confRec;
		
		this.parser.setContentHandler(this);
	}
	
	@Override
	public void startElement(String namespaceuri, String localName, String qName, Attributes attr) {
		contents.reset();
	}
	
	@Override
	public void endElement(String namespaceuri, String localName, String qName) {
		// Add the logic here for individual attributes
		if( qName.equals("start_date")) {
			confRec.setStartDate(contents.toString());
		} else if( qName.equals("end_date") ) {
			confRec.setEndDate(contents.toString());
		} else if( qName.equals("city")) {
			confRec.setCity(contents.toString());
		} else if( qName.equals("state")) {
			confRec.setState(contents.toString());
		} else if( qName.equals("country")) {
			confRec.setCountry(contents.toString());
		} else if( qName.equals("conference_rec")) {
			parser.setContentHandler(parent);
			System.out.println(this.confRec);
		}
		// Add logic here to revert the parser.setContentHandler back to parent
		// parser.setContentHandler(parent);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		contents.write(ch, start, length);
	}

}
