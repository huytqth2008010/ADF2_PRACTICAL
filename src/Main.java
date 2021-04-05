import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Contact> contacts = new HashMap<>();
		while(true) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the application option:");
		System.out.println("1. Add new contact");
		System.out.println("2. Find a contact by name");
		System.out.println("3. Display contacts");
		System.out.println("4. Exit");

		int option = scanner.nextInt();
		
			if(1 == option) {
				// Add new contact
				System.out.println("Input name: ");
				String name = scanner.next();
				System.out.println("Input phone number: ");
				String phoneNumber = scanner.next();
				contacts.put(name, new Contact(name, phoneNumber));
			} else if(2 == option) {
				System.out.println("Input name to find: ");
				String findName = scanner.next();
				if(!contacts.containsKey(findName)) {
					System.out.println("Not found");
				}else {
					System.out.println("Phone number of " + findName + "is: ");
					System.out.println(contacts.get(findName).getPhone());
				}
			} else if(3 == option) {
				if(!contacts.isEmpty()) {
					System.out.println("Show all contacts");
					contacts.entrySet().forEach(entry -> {
						System.out.println(String.format("%-20s%s", "Name", "Phone Number"));
						System.out.println("--------------------|-------------------");
						System.out.println(String.format("%-20s%s", entry.getValue().getName() , entry.getValue().getPhone()));
						System.out.println("------SUCCESS------");
					});
				}else {
					System.out.println("No contacts");
				}
			} else if(4 == option) {
				scanner.close();
				System.exit(0);
			}
		}
	}

}
