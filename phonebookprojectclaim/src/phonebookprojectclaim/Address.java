package phonebookprojectclaim;

public class Address {
	
	// variables
	private String street;
	private String city;
	private String state;
	private int zipcode;
	
	// constructor no parameters
	public Address() {
		
	}
	
	// constructor with parameters
	public Address(String street, String city, String state, int zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipCode;
	}
	
	// toString()
	public String toString() {
		return street + ", " + city + ", " + state + ", " + zipcode;
		}

	// getters and setters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public int getZipCode() {
		return zipcode;
	}

	public void setZipCode(int zipCode) {
		this.zipcode = zipCode;
	}
	
	
	
	
	

}
