import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementSystem {

    private final ArrayList<Patient> patients;
    private final Scanner scanner;

    public HospitalManagementSystem() {
        this.patients = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Hospital Management System!");
        displayMenu();
        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            processChoice(choice);
        } while (choice != 5);
        System.out.println("Exiting the system. Goodbye!");
        scanner.close(); // Close Scanner to prevent resource leaks
    }

    private void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patients");
        System.out.println("3. Search Patient");
        System.out.println("4. Delete Patient");
        System.out.println("5. Exit");
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                addPatient();
                break;
            case 2:
                viewPatients();
                break;
            case 3:
                searchPatient();
                break;
            case 4:
                deletePatient();
                break;
            case 5:
                // Exit handled in the loop
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter patient problems: ");
        String problems = scanner.nextLine();
        patients.add(new Patient(name, age, problems));
        System.out.println("Patient added successfully!");
    }

    private void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found in the system.");
        } else {
            System.out.println("All Patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    private void searchPatient() {
        System.out.print("Enter patient name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Patient Found:");
                System.out.println(patient);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    private void deletePatient() {
        System.out.print("Enter patient name to delete: ");
        String deleteName = scanner.nextLine();
        boolean deleted = false;
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getName().equalsIgnoreCase(deleteName)) {
                patients.remove(i);
                deleted = true;
                System.out.println("Patient deleted successfully.");
                break;
            }
        }
        if (!deleted) {
            System.out.println("Patient not found.");
        }
    }

    public static void main(String[] args) {
        HospitalManagementSystem system = new HospitalManagementSystem();
        system.start();
    }
}

class Patient {

    private final String name;
    private final int age;
    private final String problems;

    public Patient(String name, int age, String problems) {
        this.name = name;
        this.age = age;
        this.problems = problems;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getProblems() {
        return problems;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Problems: " + problems;
    }
}