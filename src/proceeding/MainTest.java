package proceeding;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainTest {

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
//			String fileName              = "O:\\Workspace\\SAX\\resource\\ProceedingRec.xml";
			String fileName              = "C:\\Users\\Peter\\git\\SAX\\resource\\ProceedingRec.xml";
			InputStream fileInput        = new FileInputStream(fileName);
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
