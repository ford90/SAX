package driverVehicleInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DriverVehicleHandler extends DefaultHandler{
	
	public List<Driver>			drivers  = new ArrayList<Driver>();
	public Map<String, Vehicle>	vehicles = new HashMap<String, Vehicle>();
	
	private	Stack<String> elementStack = new Stack<String>();
	private Stack<Object> objectStack  = new Stack<Object>();
	
	@Override
	public void startDocument() {
		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
								Attributes attributes) throws SAXException {
//		Add name of current element inside stack
		this.elementStack.push(qName);
//		Determine name of element
		if (qName.equals("driver")) {
			Driver driver = new Driver();
			// Add Driver object to Object STack
			this.objectStack.push(driver);
			// Add Driver to drivers List
			this.drivers.add(driver);
		} else if (qName.equals("vehicle")) {
			this.objectStack.push(new Vehicle());
		}
		
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		
		this.elementStack.pop();
		
		if ("vehicle".equals(qName) || "driver".equals(qName)) {
			Object object = this.objectStack.pop();
			if("vehicle".equals(qName)){
				Vehicle vehicle = (Vehicle) object;
				this.vehicles.put(vehicle.getVehicleId(), vehicle);
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length ) {
		String value = new String(ch, start, length);
		if ( value.length() == 0) 
			return; // ignores whitespace
		
		if( "driverId".equalsIgnoreCase(currentElement()) ) {
			Driver driver = (Driver) this.objectStack.peek();
			if (driver.getDriverId() == null )
				driver.setDriverId(value);
			else
				driver.setDriverId("");
		}
		else if( "name".equalsIgnoreCase(currentElement()) && "driver".equalsIgnoreCase(currentParentElement()) ) {
			Driver driver = (Driver) this.objectStack.peek();
			if( driver.getName() == null )
				driver.setName(value);
		}
		else if( "vehicleId".equalsIgnoreCase(currentElement())&& "driver".equalsIgnoreCase(currentParentElement()) ) {
			Driver driver = (Driver) this.objectStack.peek();
			driver.vehicles.add(this.vehicles.get(value));
		}
		else if( "vehicleId".equalsIgnoreCase(currentElement())&& "vehicle".equalsIgnoreCase(currentParentElement()) ) {
			Vehicle vehicle = (Vehicle) this.objectStack.peek();
			if(vehicle.getVehicleId() == null) {
				vehicle.setVehicleId(value);
			}
		}
		else if( "name".equalsIgnoreCase(currentElement()) && "vehicle".equalsIgnoreCase(currentParentElement()) )  {
			Vehicle vehicle = (Vehicle) this.objectStack.peek();
			if(vehicle.getName()== null	) {
				vehicle.setName(value);
			}
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
	
	@Override
	public void endDocument() {
		
	}
}
