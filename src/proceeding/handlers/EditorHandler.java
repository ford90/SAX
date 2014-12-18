package proceeding.handlers;

import java.io.CharArrayWriter;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import proceeding.Editor;

public class EditorHandler extends DefaultHandler{
	
	private ContentHandler 	parent;
	private XMLReader		parser;
	private Editor			editor;
	private CharArrayWriter contents = new CharArrayWriter();
	
	public void read(XMLReader parser, ContentHandler parent, Editor editor) {
		this.parser = parser;
		this.parent = parent;
		this.editor = editor;
		
		this.parser.setContentHandler(this);
	}
	
	@Override
	public void startElement(String namespaceUri, String localName, String qName, Attributes attr) {
		contents.reset();
	}
	
	@Override
	public void endElement(String namespaceUri, String localName, String qName) {
		String value = contents.toString();
		if (qName.equals("seq_no")) {
			editor.setSeqNo(new Integer(value));
		} else if(qName.equals("first_name")) {
			editor.setFirstName(value);
		} else if(qName.equals("last_name")) {
			editor.setLastName(value);
		} else if(qName.equals("affiliation")) {
			editor.setAffil(value);
		} else if(qName.equals("email_address")) {
			editor.setEmail(value);
		} else if(qName.equals("ch_ed")) {
			this.parser.setContentHandler(parent);
			System.out.println(this.editor);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		contents.write(ch,start,length);
	}
}
