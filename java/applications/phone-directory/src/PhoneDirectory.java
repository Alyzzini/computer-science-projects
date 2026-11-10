// Phone Directory. See README.md for usage.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class PhoneDirectory {

    static Scanner keyboard = new Scanner(System.in);
    static ArrayList<Member> directory = new ArrayList<Member>();

    public static void main(String[] args) {
        try {
            runDirectory();
        } catch (NoSuchElementException e) {
            System.out.println("\nInput ended. Exiting without saving (in-memory demo).");
        }
    }

    private static String readLine() {
        if (!keyboard.hasNextLine()) throw new NoSuchElementException("End of input");
        return keyboard.nextLine().trim();
    }

    private static String readName() {
        String name = readLine().replaceAll("\\s+", " ");
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter member name: ");
            name = readLine().replaceAll("\\s+", " ");
        }
        return name;
    }

    private static void runDirectory() {
        loadData();

        int choice = 0;

        while (choice != 8) {
            showMenu();
            choice = readChoice();

            if (choice == 1) {
                lookUpPhoneNumber();
            } else if (choice == 2) {
                addMember();
            } else if (choice == 3) {
                changePhoneNumber();
            } else if (choice == 4) {
                displayAllMembers();
            } else if (choice == 5) {
                displayByAreaCode();
            } else if (choice == 6) {
                removeMember();
            } else if (choice == 7) {
                sortByLastName();
                displayAllMembers();
            } else if (choice == 8) {
                System.out.println("Exiting the program...");
            } else {
                System.out.println("Invalid choice. Please enter 1 to 8.");
            }

            System.out.println();
        }
    }

    // Shows the menu
    public static void showMenu() {
        System.out.println("Phone Directory Project");
        System.out.println("1. Look up a phone number");
        System.out.println("2. Add a member along with a phone number");
        System.out.println("3. Change a phone number of an existing member");
        System.out.println("4. Display all the members and their phone numbers");
        System.out.println("5. Display the members from a certain area code and their phone numbers");
        System.out.println("6. Remove a member from the phone directory");
        System.out.println("7. Sort by last name");
        System.out.println("8. Exit the program");
        System.out.print("Enter your choice: ");
    }

    // Reads the user's menu choice
    public static int readChoice() {
        String input = readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // Option 1: Look up a phone number
    public static void lookUpPhoneNumber() {
        System.out.print("Enter member name: ");
        String name = readName();

        int index = findMember(name);

        if (index != -1) {
            System.out.println(directory.get(index).name + "  " + directory.get(index).phoneNumber);
        } else {
            System.out.println("Member not found in the phone directory.");
        }
    }

    // Option 2: Add a new member
    public static void addMember() {
        System.out.print("Enter member name: ");
        String name = readName();

        int index = findMember(name);

        if (index != -1) {
            System.out.println("Member already exists in the phone directory");
            return;
        }

        System.out.print("Enter phone number: ");
        String phone = readLine();
        phone = formatPhoneNumber(phone);

        while (phone == null) {
            System.out.print("Invalid phone number. Enter again: ");
            phone = readLine();
            phone = formatPhoneNumber(phone);
        }

        directory.add(new Member(name, phone));
        System.out.println("Member successfully added");
    }

    // Option 3: Change a member's phone number
    public static void changePhoneNumber() {
        System.out.print("Enter member name: ");
        String name = readName();

        int index = findMember(name);

        if (index == -1) {
            System.out.println("Member not found in the phone directory.");
            return;
        }

        System.out.print("Enter new phone number: ");
        String phone = readLine();
        phone = formatPhoneNumber(phone);

        while (phone == null) {
            System.out.print("Invalid phone number. Enter again: ");
            phone = readLine();
            phone = formatPhoneNumber(phone);
        }

        directory.get(index).phoneNumber = phone;
        System.out.println("Phone number updated successfully.");
    }

    // Option 4: Display all members
    public static void displayAllMembers() {
        if (directory.size() == 0) {
            System.out.println("Phone directory is empty.");
            return;
        }

        for (int i = 0; i < directory.size(); i++) {
            System.out.printf("%-25s%s%n", directory.get(i).name, directory.get(i).phoneNumber);
        }
    }

    // Option 5: Display members by area code
    public static void displayByAreaCode() {
        System.out.print("Enter area code: ");
        String areaCode = readLine();
        while (!areaCode.matches("[0-9]{3}")) {
            System.out.print("Area code must contain exactly three digits. Enter again: ");
            areaCode = readLine();
        }

        boolean found = false;

        for (int i = 0; i < directory.size(); i++) {
            if (directory.get(i).phoneNumber.startsWith(areaCode)) {
                System.out.printf("%-25s%s%n", directory.get(i).name, directory.get(i).phoneNumber);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No members found with that area code.");
        }
    }

    // Option 6: Remove a member
    public static void removeMember() {
        System.out.print("Enter member name to remove: ");
        String name = readName();

        int index = findMember(name);

        if (index != -1) {
            directory.remove(index);
            System.out.println("Member removed from the phone directory.");
        } else {
            System.out.println("Member not found in the phone directory.");
        }
    }

    // Option 7: Sort by last name
    public static void sortByLastName() {
        for (int i = 0; i < directory.size() - 1; i++) {
            for (int j = i + 1; j < directory.size(); j++) {
                String lastName1 = getLastName(directory.get(i).name);
                String lastName2 = getLastName(directory.get(j).name);

                if (lastName1.compareToIgnoreCase(lastName2) > 0) {
                    Member temp = directory.get(i);
                    directory.set(i, directory.get(j));
                    directory.set(j, temp);
                }
            }
        }

        System.out.println("Directory sorted by last name.");
    }

    // Finds a member by name
    public static int findMember(String name) {
        for (int i = 0; i < directory.size(); i++) {
            if (directory.get(i).name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // Gets the last name from the full name
    public static String getLastName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        return parts[parts.length - 1];
    }

    // Formats phone number as xxx-xxx-xxxx
    public static String formatPhoneNumber(String phone) {
        if (phone == null || !phone.matches("[0-9() .-]+")) return null;
        String digits = phone.replaceAll("[^0-9]", "");

        if (digits.length() == 10) {
            return digits.substring(0, 3) + "-"
                 + digits.substring(3, 6) + "-"
                 + digits.substring(6);
        } else {
            return null;
        }
    }

    // replacement synthetic fixtures; reserved 555-0100 through 555-0119 numbers.
    public static void loadData() {
        directory.clear();
        directory.add(new Member("Demo Aster", "202-555-0100"));
        directory.add(new Member("Demo Birch", "303-555-0101"));
        directory.add(new Member("Demo Cedar", "415-555-0102"));
        directory.add(new Member("Demo Dahlia", "202-555-0103"));
        directory.add(new Member("Demo Elm", "303-555-0104"));
        directory.add(new Member("Demo Fern", "415-555-0105"));
        directory.add(new Member("Demo Grove", "202-555-0106"));
        directory.add(new Member("Demo Hazel", "303-555-0107"));
        directory.add(new Member("Demo Iris", "415-555-0108"));
        directory.add(new Member("Demo Juniper", "202-555-0109"));
        directory.add(new Member("Demo Kestrel", "303-555-0110"));
        directory.add(new Member("Demo Linden", "415-555-0111"));
        directory.add(new Member("Demo Maple", "202-555-0112"));
        directory.add(new Member("Demo Nectar", "303-555-0113"));
        directory.add(new Member("Demo Oak", "415-555-0114"));
        directory.add(new Member("Demo Pine", "202-555-0115"));
        directory.add(new Member("Demo Quartz", "303-555-0116"));
        directory.add(new Member("Demo Reed", "415-555-0117"));
        directory.add(new Member("Demo Spruce", "202-555-0118"));
        directory.add(new Member("Demo Thyme", "303-555-0119"));
    }

    // Member class
    static class Member {
        String name;
        String phoneNumber;

        public Member(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
