
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    //contact of person stored in arraylist
    public ArrayList<ContactsOfPersons> contactList = new ArrayList<>();
    public HashMap<String, ArrayList<ContactsOfPersons>> personByCity;
    public HashMap<String, ArrayList<ContactsOfPersons>> personByState;
    
    public AddressBook() {
    	personByCity = new HashMap<String, ArrayList<ContactsOfPersons>>();
    	personByState = new HashMap<String, ArrayList<ContactsOfPersons>>();
    	contactList = new ArrayList<>();
    }
    
    public ArrayList<ContactsOfPersons> addContactDetails(){
        System.out.println("Enter the Details of Contact Details  person");
        System.out.println("Enter the first name");
        String firstName = sc.next();
        if (Duplicate(firstName)) {
        	System.out.println("Person with this name is already exist");
        }
        else {
        System.out.println("Enter the Last name");
        String lastName = sc.next();
        System.out.println("Enter the Address");
        String address = sc.next();
        System.out.println("Enter the City");
        String city = sc.next();
        System.out.println("Enter the State");
        String state = sc.next();
        System.out.println("Enter the email");
        String email = sc.next();
        System.out.println("Enter the ZipCode");
        String zip = sc.next();
        System.out.println("Enter the contact number...");
        String phoneNumber = sc.next();
        //passing the value in constructor
        ContactsOfPersons contactofPerson = new ContactsOfPersons(firstName, lastName, address, city, state, email, phoneNumber, zip);
        contactList.add(contactofPerson);
        if (!personByState.containsKey(state)) {
        	personByState.put(state, new ArrayList<ContactsOfPersons>());
        }
        personByState.get(state).add(contactofPerson);
        
        if (!personByCity.containsKey(city)) {
        	personByCity.put(city, new ArrayList<ContactsOfPersons>());
        }
        personByCity.get(city).add(contactofPerson);
        }
		return contactList;
    }

    public boolean editContactDetails(String Name) {
        int flag = 0;
        for(ContactsOfPersons contact: contactList)
        {
            if(contact.getFirstName().equals(Name))		//used equal to method for check name
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Address: ");
                String address = sc.next();
                contact.setAddress(address);
                System.out.println("Enter City: ");
                String city = sc.next();
                contact.setCity(city);
                System.out.println("Enter State: ");
                String state = sc.next();
                contact.setState(state);
                System.out.println("Enter Email: ");
                String email = sc.next();
                contact.setEmail(email);
                System.out.println("Enter Phone Number:");
                String phoneNumber = sc.next();
                contact.setPhoneNumber(phoneNumber);
                System.out.println("Enter Zip Code: ");
                String zip = sc.next();
                contact.setZip(zip);
                flag = 1;
            }
        }
        return flag == 1;
    }
    public boolean deleteContact(String name) {
        int flag = 0;
        for(ContactsOfPersons contact: contactList)
        {
            if(contact.getFirstName().equals(name))
            {
                contactList.remove(contact);
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }
    
    public boolean Duplicate(String fname)
    {
        int flag=0;
        for (ContactsOfPersons p: contactList)
        {
            if (p.getFirstName().equals(fname))
            {
                flag=1;
                break;
            }
        }
        return flag == 1;
    }
    
    // used java stream
    public void getPersonNameByState(String State) {
        List<ContactsOfPersons> list = contactList.stream().filter(contactName -> contactName.getState().equals(State))
                .collect(Collectors.toList());
        for (ContactsOfPersons contact : list) {
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
        }

    }

    public void getPersonNameByCity(String cityName) {
        List<ContactsOfPersons> list = contactList.stream().filter(contactName -> contactName.getCity().equals(cityName))
                .collect(Collectors.toList());
        for (ContactsOfPersons contact : list) {
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
        }
    }
    public void display() {
        for (ContactsOfPersons person : contactList)				//Display method
            System.out.println(person);
    }
}