package phonebookprojectclaim;

public class Person {
	
	// variables
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private Address address;
	
	// constructor no parameters
	public Person() {
		
	}
	
	// constructor with parameters
	public Person(String firstName, String lastName, long phoneNumber, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	// toString()
	public String toString() {
		return firstName + " " + lastName + " " + String.valueOf(phoneNumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3") + " " + address.toString();
	}
	
	// getters and setters
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
