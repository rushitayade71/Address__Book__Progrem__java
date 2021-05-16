package AddressBook;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class BookList {

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Management System using Java Stream");
        Address_Book_System addBookSystem = new Address_Book_System();
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        boolean flag =true;

        while (flag)
        {
            System.out.println("1.Add New Address Book");
            System.out.println("2.Search from a City");
            System.out.println("3.Search from a State");
            System.out.println("4.View contact By State Using State and Person HashMap");
            System.out.println("5.View Contact by city Using City and Person HashMap");
            System.out.println("6.Count Contact By State");
            System.out.println("7.Count Contact By City");
            System.out.println("8.Sort Contact By Name");
            System.out.println("9.Sort Contact By City");
            System.out.println("10.Sort Contact By State");
            System.out.println("11.Write data");
            System.out.println("12.Read data");
            System.out.println("13.Write Data from csv File");
            System.out.println("14.Read Data into csv File");
            System.out.println("15.Exit");
            System.out.println("Enter choice: ");
            int option = sc.nextInt();
            switch (option){
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = sc.next();
                    if(Address_Book_System.addressBookListMap.containsKey(addressBookName)){
                        System.out.println("The Address book Already Exists");
                        addBookSystem.addAddressBook(addressBookName);
                        break;
                    }else {
                        addBookSystem.addAddressBook(addressBookName);
                        break;
                    }
                }
                case 2: {
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
                    System.out.println("Enter Name of State: ");
                    String stateName2 = sc.next();
                    addBookSystem.CountByState(stateName2);
                    break;
                }

                case 7:{
                    System.out.println("Enter Name of City: ");
                    String cityName2 = sc.next();
                    addBookSystem.CountByCity(cityName2);
                    break;
                }

                case 8:{
                    System.out.println("Sort Contact");
                    addBookSystem.sortContactByName();
                    break;
                }

                case 9:{
                    System.out.println("Sort Contact By City");
                    addBookSystem.sortContactByCity();
                    break;
                }

                case 10: {
                    System.out.println("Sort Contact By State");
                    addBookSystem.sortContactByState();
                    break;
                }

                case 11: {
                    AddressBook.writeData(addBookSystem);
                    break;
                }

                case 12: {
                    AddressBook.readData(addBookSystem);
                    break;
                }

                case 13:
                    try{
                        AddressBook.writeDataToCSV();
                    } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
                        e.printStackTrace();
                    }

                case 14:
                    try{
                        AddressBook.readDataFromCSV();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }

                case 15: {
                    flag = false;
                    break;
                }

            }

        }
    }
}


