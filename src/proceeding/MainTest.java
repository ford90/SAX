package proceeding;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainTest {

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			InputStream fileInput        = new FileInputStream("O:\\Workspace\\SAX\\resource\\ProceedingRec.xml");
			SAXParser parser             = factory.newSAXParser();
			MainHandler handler = new MainHandler();
			
			parser.parse(fileInput, handler);
			
			for(ProceedingRec procRec : handler.procRecs) {
				System.out.println(procRec);
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
			
	}

}
