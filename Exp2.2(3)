import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, designation;
    double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary);
    }
}

public class Exp22_Hard {
    static final String FILE_NAME = "employees.ser";
    
    public static void addEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, designation, salary);
        List<Employee> employees = readEmployees();
        employees.add(emp);
        writeEmployees(employees);
        System.out.println("Employee added successfully!\n");
    }

    public static void displayAllEmployees() {
        List<Employee> employees = readEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.\n");
        } else {
            for (Employee emp : employees) {
                emp.display();
            }
            System.out.println();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) in.readObject();
        } catch (FileNotFoundException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file.");
        }
        return employees;
    }

    public static void writeEmployees(List<Employee> employees) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee\n2. Display All\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}
