package driverVehicleInfo;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class DriverVehicleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			InputStream fileInput        = new FileInputStream("O:\\Workspace\\SAX\\resource\\Test.xml");
			SAXParser parser             = factory.newSAXParser();
			DriverVehicleHandler handler = new DriverVehicleHandler();
			
			parser.parse(fileInput, handler);
			
			for(Driver driver : handler.drivers) {
				System.out.println(driver);
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		

	}

}
