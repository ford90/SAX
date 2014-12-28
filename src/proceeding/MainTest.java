package proceeding;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

import proceeding.DAOManager.Table;
import proceeding.dao.GenericDAO;
import proceeding.dao.ProceedingDAO;
import proceeding.model.Proceeding;

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
			
//			System.out.println(Printable.listOfObjects.size());
//			int count = 0;
//			for(Printable obj : Printable.listOfObjects) {
//				count++;
//				System.out.println("Printable object " + count  + ": "  + obj.toString() );
//			}
	
			/***** Get Printable objects and create new Proceeding object from Printable*****/
			Proceeding proceeding = new Proceeding();
			for(Printable obj : Printable.listOfObjects ) {
				if(obj instanceof ConferenceRec) {
					ConferenceRec confRec = (ConferenceRec) obj;
					proceeding.setConfStartDt(confRec.getStartDate());
					proceeding.setConfEndDt(confRec.getEndDate());
					proceeding.setConfLocCity(confRec.getCity());
					proceeding.setConfLocState(confRec.getState());
				}
				else if(obj instanceof ProceedingRec) {
					ProceedingRec procRec = (ProceedingRec) obj;
					proceeding.setAcronym(procRec.getAcronym());
					proceeding.setCpYear(procRec.getCopyYear());
					proceeding.setIsbn(procRec.getIsbn());
				}
			}
			
			DAOManager daoManager = new DAOManager();
			ProceedingDAO dao = (ProceedingDAO)daoManager.getDAO(Table.PROCEEDING);
			System.out.println("Row Count : " + dao.count());
			dao.update(proceeding);

		} catch (Throwable e) {
			e.printStackTrace();
		}
			
	}

}
