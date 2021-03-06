package proceeding.handlers;

import java.io.CharArrayWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import proceeding.ConferenceRec;
import proceeding.Editor;
import proceeding.Printable;
import proceeding.ProceedingRec;

public class MainHandler2 extends DefaultHandler {
	
	private XMLReader 						parser;
	private ConferenceRecHandler			confRecHandler	= new ConferenceRecHandler();
	private ProceedingRecHandler			procRecHandler	= new ProceedingRecHandler();
	private CharArrayWriter					contents		= new CharArrayWriter();
	private ArrayList<Printable>			printables		= new ArrayList<Printable>();
	
	public MainHandler2(XMLReader parser) {
		this.parser = parser;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// This contains all the logic on where to delegate the Handler
		if(qName.equals("proceeding_rec")) {
			ProceedingRec procRec	= new ProceedingRec();
			this.procRecHandler.read(parser, this, procRec);
			printables.add(procRec);
			
		} else if(qName.equals("conference_rec")) {
			ConferenceRec confRec	= new ConferenceRec();
			this.confRecHandler.read(parser, this, confRec);
			printables.add(confRec);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
		throws SAXException{
		// Should remain empty
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {		
		// Append values to contentWriter
		contents.write(ch, start, length);
	}
	
	public ArrayList<Printable> getPrintables() {
		return printables;
	}
	
	
}
