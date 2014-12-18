package proceeding;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class MainTest {

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
//			String fileName              = "O:\\Workspace\\SAX\\resource\\ProceedingRec.xml";
			String fileName              = "C:\\Users\\Peter\\git\\SAX\\resource\\ProceedingRec.xml";
			InputStream fileInput        = new FileInputStream(fileName);
			SAXParser parser             = factory.newSAXParser();
//			MainHandler handler = new MainHandler();
			XMLReader reader			 = parser.getXMLReader(); 
			proceeding.handlers.MainHandler2 handler = new proceeding.handlers.MainHandler2(reader);
			parser.parse(fileInput, handler);
			
//			for(ProceedingRec procRec : handler.procRecs) {
//				System.out.println(procRec);
//			}
			for(Printable printable : handler.getPrintables() ) {
				System.out.println(printable);
			}
			
			System.out.println(handler.getPrintables().size());
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
			
	}

}
