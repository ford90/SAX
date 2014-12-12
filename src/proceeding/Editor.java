package proceeding;

public class Editor {
	private int    seqNo;
	private String firstName;
	private String lastName;
	private String affil;
	private String email;
	
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAffil() {
		return affil;
	}
	public void setAffil(String affil) {
		this.affil = affil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "\n" + "seq_no  : " + seqNo + "\n" +
				": Name  : " + firstName + " " + lastName + "\n" +
				": Affil : " + affil + "\n" +
				": Email : " + email + "\n" ;
	}
}
