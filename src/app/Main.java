package app;
import java.util.List;
import java.util.Scanner;

import dao.StudentDAO;
import model.Student;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. List All Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
         // POST /students → Add new student
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    String rollNo = sc.nextLine();
                    if (name.isEmpty() || rollNo.isEmpty()) {
                        System.out.println("Name and Roll Number cannot be empty.");
                        break;
                    }
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    if (dao.addStudent(new Student(name, rollNo, dept, year))) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Failed to add student.");
                    }
                }
             // PUT /students/{id} → Update student
                case 2 -> {
                    System.out.print("Enter student ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new roll number: ");
                    String rollNo = sc.nextLine();
                    System.out.print("Enter new department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter new year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    if (dao.updateStudent(new Student(id, name, rollNo, dept, year))) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Failed to update student.");
                    }
                }
             // DELETE /students/{id} → Delete student
                case 3 -> {
                    System.out.print("Enter student ID to delete: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (dao.deleteStudent(id)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Failed to delete student.");
                    }
                }
             // GET /students?search=keyword → Search students
                case 4 -> {
                    System.out.print("Enter name or roll number to search: ");
                    String keyword = sc.nextLine();
                    List<Student> students = dao.searchStudents(keyword);
                    if (students.isEmpty()) System.out.println("No students found.");
                    else students.forEach(s -> System.out.println(
                            "ID: " + s.getId() +
                            ", Name: " + s.getName() +
                            ", Roll No: " + s.getRollNo() +
                            ", Dept: " + s.getDepartment() +
                            ", Year: " + s.getYear()
                    ));
                }
             // GET /students → List all students
                case 5 -> {
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) System.out.println("No students in database.");
                    else students.forEach(s -> System.out.println(
                            "ID: " + s.getId() +
                            ", Name: " + s.getName() +
                            ", Roll No: " + s.getRollNo() +
                            ", Dept: " + s.getDepartment() +
                            ", Year: " + s.getYear()
                    ));
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
