package phonebookprojectclaim;

import java.util.Scanner;

public class PhoneBookMain {
	
	static Person[] phoneBook = new Person[0];
	
	static int personCount = 0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		userMenuSelection();

	}
	
	// menu 
	public static void displayMenu() {
		System.out.println("***Phone Book***");
		System.out.println();
		System.out.println("------Menu------");
		System.out.println("1. Add new entry");
		System.out.println("2. Search by first name");
		System.out.println("3. Search by last name");
		System.out.println("4. Search by full name");
		System.out.println("5. Search by telephone number");
		System.out.println("6. Search by city");
		System.out.println("7. Search by state");
		System.out.println("8. Delete with telephone number");
		System.out.println("9. Update with telephone number");
		System.out.println("10. Show records in ascending order");
		System.out.println("11. Exit program");
		System.out.println();
		System.out.println("Please enter one of the above integers: ");
		
	}
	
	// user selection with switch
	public static void userMenuSelection() {
		boolean continueLoop = true;
		while(continueLoop) {
			displayMenu();
			Scanner scan = new Scanner(System.in);
			int userChoice = scan.nextInt();
			switch(userChoice){
			case 1:
				System.out.println("User Selected 1");
				System.out.println("Please enter information as 'first name,lastname,street,city,state,zipcode,phonenumber': ");
				System.out.println("Example 'John,Doe,114 Market St,St Louis,MO,63403,6366435698': ");
				Scanner sc1 = new Scanner(System.in);
				String line;
				String[] lineArray;
				line = sc1.nextLine();
				lineArray = line.split(",");
				String firstName = lineArray[0];
				String lastName = lineArray[1];
				String street = lineArray[2];
				String city = lineArray[3];
				String state = lineArray[4];
				int zipcode = Integer.parseInt(lineArray[5]);
				long phoneNumber = Long.parseLong(lineArray[6]);
				
				Person newPerson = new Person(firstName, lastName, phoneNumber, new Address(street, city, state, zipcode));
				addEntry(newPerson);
				System.out.println(newPerson.toString());
				
				break;
			case 2: 
				System.out.println("User Selected 2");
				System.out.println("Please enter first name to search: ");
				Scanner sc2 = new Scanner(System.in);
				String firstNameToSearch = sc2.next();
				Person[] firstNameArray = searchFirstName(firstNameToSearch);
				printPersonArray(firstNameArray);
				break;
			case 3:
				System.out.println("User Selected 3");
				System.out.println("Please enter last name to search: ");
				Scanner sc3 = new Scanner(System.in);
				String lastNameToSearch = sc3.next();
				Person[] lastNameArray = searchLastName(lastNameToSearch);
				printPersonArray(lastNameArray);
				break;
			case 4:
				System.out.println("User Selected 4");
				System.out.println("Please enter first name to search: ");
				Scanner sc4 = new Scanner(System.in);
				String firstNameToLookFor = sc4.next();
				System.out.println("Please enter last name to search: ");
				String lastNameToLookFor = sc4.next();
				Person[] fullNameArray = searchFullName(firstNameToLookFor, lastNameToLookFor);
				printPersonArray(fullNameArray);
				break;
			case 5:
				System.out.println("User Selected 5");
				System.out.println("Please enter telephone number to search: ");
				Scanner sc5 = new Scanner(System.in);
				long numberToSearch = sc5.nextLong();
				Person[] phoneNumberArray = searchPhoneNumber(numberToSearch);
				printPersonArray(phoneNumberArray);
				break;
			case 6:
				System.out.println("User Selected 6");
				System.out.println("Please enter city to search: ");
				Scanner sc6 = new Scanner(System.in);
				String cityToSearch = sc6.nextLine();
				Person[] cityArray = searchCity(cityToSearch);
				printPersonArray(cityArray);
				break;
			case 7:
				System.out.println("User Selected 7");
				System.out.println("Please enter state to search(e.g. MO): ");
				Scanner sc7 = new Scanner(System.in);
				String stateToSearch = sc7.next();
				Person[] stateArray = searchState(stateToSearch);
				printPersonArray(stateArray);
				break;
			case 8:
				System.out.println("User Selected 8");
				System.out.println("Please enter phone number to delete: ");
				Scanner sc8  = new Scanner(System.in);
				long numberToDelete = sc8.nextLong();
				deleteNumber(numberToDelete);
				break;
			case 9:
				System.out.println("User Selected 9");
				System.out.println("Please enter phone number to update: ");
				Scanner sc9 = new Scanner(System.in);
				long numberToUpdate = sc9.nextLong();
				updateRecordWithPhoneNumber(numberToUpdate);
				break;
			case 10:
				System.out.println("User Selected 10");
				// print phone book
				printPhoneBook();
				System.out.println();
				System.out.println("Alphabetical order based off last name: ");
				ascendArray();
				System.out.println();
				printPhoneBook();
				
				break;
			case 11:
				System.out.println("11");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid integer.");
				break;
				
				
			}
			
		}
		
	}
	
	// 1 add entry
	public static void addEntry(Person person) {
		Person[] newArray = new Person[phoneBook.length + 1];
		for (int i = 0; i < phoneBook.length; i++) {
			newArray[i] = phoneBook[i];
		}
		newArray[phoneBook.length] = person;
		phoneBook = newArray;
		
		
		
	}
	
	// 2 search by first name
	public static Person[] searchFirstName(String firstName) {
		int count = 0;
		int countForReturnArray = 0;
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getFirstName().toLowerCase().equals(firstName.toLowerCase())) {
				count++;
			}
			
		}
		Person[] firstNameArray = new Person[count];
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getFirstName().toLowerCase().equals(firstName.toLowerCase())) {
				firstNameArray[countForReturnArray] = phoneBook[i];
				countForReturnArray++;
			}
			
		}
		return firstNameArray;
		
	}
	
	// 3 search by last name
	public static Person[] searchLastName(String lastName) {
		int count = 0;
		int countForReturnArray = 0;
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				count++;
			}
			
		}
		Person[] lastNameArray = new Person[count];
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				lastNameArray[countForReturnArray] = phoneBook[i];
				countForReturnArray++;
			}
			
		}
		return lastNameArray;
		
	}
	
	// 4 searchFullName
	public static Person[] searchFullName(String firstName, String lastName) {
		int count = 0;
		int countForReturnArray = 0;
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getFirstName().toLowerCase().equals(firstName.toLowerCase()) && phoneBook[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				count++;
			}
			
		}
		Person[] fullNameArray = new Person[count];
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getFirstName().toLowerCase().equals(firstName.toLowerCase()) && phoneBook[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				fullNameArray[countForReturnArray] = phoneBook[i];
				countForReturnArray++;
			}
			
		}
		return fullNameArray;
		
	}
	
	// 5 telephone search
	public static Person[] searchPhoneNumber(long number) {
		int count = 0;
		int countForReturnArray = 0;
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getPhoneNumber() == number) {
				count++;
			}
			
		}
		Person[] phoneNumberArray = new Person[count];
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getPhoneNumber() == number) {
				phoneNumberArray[countForReturnArray] = phoneBook[i];
				countForReturnArray++;
			}
			
		}
		return phoneNumberArray;
		
	}
	
	// 6 city search
	public static Person[] searchCity(String city) {
		int count = 0;
		int countForReturnArray = 0;
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
				count++;
			}
			
		}
		Person[] cityArray = new Person[count];
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
				cityArray[countForReturnArray] = phoneBook[i];
				countForReturnArray++;
			}
			
		}
		return cityArray;
		
	}
	
	// 7 city search
	public static Person[] searchState(String state) {
		int count = 0;
		int countForReturnArray = 0;
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
				count++;
			}		
		}
		Person[] stateArray = new Person[count];
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
				stateArray[countForReturnArray] = phoneBook[i];
				countForReturnArray++;
			}
				
		}
		return stateArray;		
	}
	
	// 8 delete
	public static void deleteNumber(long number) {
		int indexToRemove = 0;
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getPhoneNumber() == number) {
				indexToRemove = i;
			}
		}
		removeAt(indexToRemove);
	}

	
	
	// 8 helper thing
	public static void removeAt(int indexToRemove) {
		int length = phoneBook.length;
		Person[] temp = new Person[length-1];
		System.arraycopy(phoneBook, 0, temp, 0, indexToRemove);
		System.arraycopy(phoneBook, indexToRemove + 1, temp, indexToRemove, length - indexToRemove - 1);
		phoneBook = temp;
	}
	
	// 9 update with phone number
	public static void updateRecordWithPhoneNumber(long number) {
		// find index of number 
		int indexToUpdate = 0;
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i].getPhoneNumber() == number) {
				indexToUpdate = i;
			}
		}
		// get new person to update
		System.out.println("Please enter information as 'first name,lastname,street,city,state,zipcode,phonenumber': ");
		System.out.println("Example 'John,Doe,114 Market St,St Louis,MO,63403,6366435698': ");
		Scanner sc = new Scanner(System.in);
		String line;
		String[] lineArray;
		line = sc.nextLine();
		lineArray = line.split(",");
		String firstName = lineArray[0];
		String lastName = lineArray[1];
		String street = lineArray[2];
		String city = lineArray[3];
		String state = lineArray[4];
		int zipcode = Integer.parseInt(lineArray[5]);
		long phoneNumber = Long.parseLong(lineArray[6]);
		
		Person newPerson = new Person(firstName, lastName, phoneNumber, new Address(street, city, state, zipcode));
		phoneBook[indexToUpdate] = newPerson;
	}
	
	// 10 ascending order
	public static void ascendArray() {
		for (int i = 0; i < phoneBook.length; i++) {
			for (int j = i + 1; j < phoneBook.length; j++) {
				if(phoneBook[i].getLastName().compareTo(phoneBook[j].getLastName()) > 0) {
					// swapper
					Person temp = phoneBook[i];
					phoneBook[i] = phoneBook[j];
					phoneBook[j] = temp;
				}
				
			}
			
		}
		
	}
	
	
	// print array
	public static void printPersonArray(Person[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
			
		}
	}
	
	// print phoneBook array
	public static void printPhoneBook() {
		for (int i = 0; i < phoneBook.length; i++) {
			System.out.println(phoneBook[i].toString());
			
		}
	}

}
