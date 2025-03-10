import java.util.*;
// Student class to store student information
class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    // Constructor to initialize a student record
    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// StudentLinkedList class to manage the student records using singly linked list
class StudentLinkedList {
    Student head;

    // Constructor to initialize the list
    public StudentLinkedList() {
        this.head = null;
    }

    // Add a student record at the beginning of the list
    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add a student record at the end of the list
    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
    }

    // Add a student record at a specific position in the list
    public void addStudentAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 0) {
            newStudent.next = head;
            head = newStudent;
            return;
        }

        Student temp = head;
        for (int i = 1; i < position; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete a student record by Roll Number
    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Search for a student record by Roll Number
    public Student searchStudentByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update a student's grade by Roll Number
    public void updateStudentGrade(int rollNumber, String newGrade) {
        Student student = searchStudentByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated for Roll Number: " + rollNumber);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    // Display all student records
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

// Main class to test the implementation
public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Adding students
        studentList.addStudentAtBeginning(1, "Alice", 20, "A");
        studentList.addStudentAtEnd(2, "Bob", 21, "B");
        studentList.addStudentAtEnd(3, "Charlie", 22, "C");
        studentList.addStudentAtPosition(2, 4, "David", 23, "B+");

        // Displaying all student records
        System.out.println("All Student Records:");
        studentList.displayAllStudents();

        // Searching for a student by Roll Number
        System.out.println("\nSearching for student with Roll Number 2:");
        Student student = studentList.searchStudentByRollNumber(2);
        if (student != null) {
            System.out.println("Found: " + student.name);
        } else {
            System.out.println("Student not found.");
        }

        // Updating a student's grade
        System.out.println("\nUpdating grade of Roll Number 3 to A+");
        studentList.updateStudentGrade(3, "A+");

        // Displaying all student records after update
        System.out.println("\nAll Student Records after grade update:");
        studentList.displayAllStudents();

        // Deleting a student by Roll Number
        System.out.println("\nDeleting student with Roll Number 2");
        studentList.deleteStudentByRollNumber(2);

        // Displaying all student records after deletion
        System.out.println("\nAll Student Records after deletion:");
        studentList.displayAllStudents();
    }
}
