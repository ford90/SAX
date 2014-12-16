package proceeding;

public class ConferenceRec implements Printable{
	private String startDate;
	private String endDate;
	private String city;
	private String state;
	private String country;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String toString() {
		return "startDate : " + startDate + "\n" +
				"endDate  : " + endDate   + "\n" +
				"city     : " + city	  + "\n" +
				"state    : " + state	  + "\n" +
				"country  : " + country	  + "\n" ;
	}
}
