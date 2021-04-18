
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Address_Book_System {
    public static Scanner sc = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String,AddressBook> addressBookListMap = new HashMap<>();

    public void addAddressBook(String addressBookName){
        Address_Book_System addBookSystem = new Address_Book_System();
        boolean flag = true;

        while(flag) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete");
            System.out.println("4.Exit");
            System.out.println("Enter Choice: ");

            int option = sc.nextInt();

            switch (option)
            {
                case 1:
                    addressBook.addContactDetails();
                    break;

                case 2:
                    System.out.println("Enter the Person First name to edit details: ");
                    String personName = sc.next();

                    boolean listEdited = addressBook.editContactDetails(personName);
                    if (listEdited) {
                        System.out.println("List Edited Successfully");
                    } else {
                        System.out.println("List Cannot be Edited");
                    }
                    break;

                case 3:
                    System.out.println("Enter the Contact to be deleted:");
                    String firstName = sc.next();
                    boolean listDeleted = addressBook.deleteContact(firstName);
                    if (listDeleted) {
                        System.out.println("Deleted Contact from the List");
                    } else {
                        System.out.println("List Cannot be Deleted");
                    }
                    break;

                case 4:
                    flag =false;
                    break;

            }
        }
        addressBookListMap.put(addressBookName, addressBook);
        System.out.println("AddressBook Added Successfully");
    }

    private void searchPersonByState(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }

    private void searchPersonByCity(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }
    
    private void viewPersonByStateUsingHashmap(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactsOfPersons> contacts = value.personByState.entrySet().stream()
                    .filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for (ContactsOfPersons contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }

    private void viewPersonByCityUsingHashMap(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactsOfPersons> contacts = value.personByCity.entrySet().stream()
                    .filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for (ContactsOfPersons contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Management System using Java Stream");
        Address_Book_System addBookSystem = new Address_Book_System();
        boolean flag =true;
        while(flag)
        {
        	while (flag)
        	{
            System.out.println("1.Add New Address Book");
            System.out.println("2.Search from a City");
            System.out.println("3.Search from a State");
            System.out.println("4.View contact By State Using State and Person HashMap");
            System.out.println("5.View Contact by city Using City and Person HashMap");
            System.out.println("6.Exit");
            System.out.println("Enter choice: ");
            int option = sc.nextInt();
            switch (option){
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = sc.next();
                    if(addBookSystem.addressBookListMap.containsKey(addressBookName)){
                        System.out.println("The Address book Already Exists");
                        break;
                    }else {
                    	addBookSystem.addAddressBook(addressBookName);
                        break;
                    }
                }
                case 2:{
                	System.out.println("Enter the City Name:-");
                	String CityName = sc.next();
                	addBookSystem.searchPersonByCity(CityName);
                	break;
                }
                	
                case 3:{
                	System.out.println("Enter the State Name:-");
                	String StateName = sc.next();
                	addBookSystem.searchPersonByState(StateName);
                	break;
                }
                
                case 4:{
                    System.out.println("Enter Name of State: ");
                    String stateName1 = sc.next();
                    addBookSystem.viewPersonByStateUsingHashmap(stateName1);
                    break;
                }

                case 5:{
                    System.out.println("Enter Name of City: ");
                    String cityName1 = sc.next();
                    addBookSystem.viewPersonByCityUsingHashMap(cityName1);
                    break;
                }
                case 6:{
                    flag = false;
                    break;
                }
            }
        }
    }
}
}
