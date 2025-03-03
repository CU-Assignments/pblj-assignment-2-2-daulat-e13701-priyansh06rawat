import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}

public class Exp22_Medium {
    public static void main(String[] args) {
        String filename = "student.ser";
        Student student = new Student(10345, "Rahul", 8.5);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(student);
            System.out.println("Serialization successful.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("\nDeserialization successful. Student details:");
            deserializedStudent.display();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error during deserialization.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
    }
}
