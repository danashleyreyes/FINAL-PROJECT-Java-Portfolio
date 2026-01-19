class Person {
    String name;
    int age;
    String gender;

    static Student[] students = new Student[3];
    static Teacher[] teachers = new Teacher[3];

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    static void displayInfo() {
        System.out.println("\n     BASIC INFORMATION");
        System.out.println("\nStudents:");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", Age: " + s.age + ", Gender: " + s.gender);
        }
        System.out.println("\nTeachers:");
        for (Teacher t : teachers) {
            System.out.println("Name: " + t.name + ", Age: " + t.age + ", Gender: " + t.gender);
        }
    }
}

class Student extends Person {
    int studentId;
    static Student[] students = new Student[3];

    public Student(String name, int age, String gender, int studentId) {
        super(name, age, gender);
        this.studentId = studentId;
    }

    static void displayStudents() {
        System.out.println("\n     STUDENTS INFORMATION\n");
        for (Student s : students) {
            System.out.println("Name: " + s.name);
            System.out.println("Age: " + s.age);
            System.out.println("Gender: " + s.gender);
            System.out.println("Student ID: " + s.studentId);
            System.out.println();
        }
    }
}

class Teacher extends Person {
    String department;
    Course[] courses;
    static Teacher[] teachers = new Teacher[3];

    public Teacher(String name, int age, String gender, String department, Course[] courses) {
        super(name, age, gender);
        this.department = department;
        this.courses = courses;
    }

    static void displayTeachers() {
        System.out.println("    TEACHERS INFORMATION\n");
        for (Teacher t : teachers) {
            System.out.println("Name: " + t.name);
            System.out.println("Age: " + t.age);
            System.out.println("Gender: " + t.gender);
            System.out.println("Department: " + t.department);
            System.out.println("Courses Handled:");
            for (Course c : t.courses) {
                System.out.println("\t" + c.courseCode + " - " + c.courseName);
            }
            System.out.println();
        }
    }
}

class Course {
    String courseCode;
    String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    static void displayCourses(Course[] courses) {
        System.out.println("     AVAILABLE COURSES\n");
        for (int i = 0; i < courses.length; i++) {
            System.out.println((i + 1) + ". " + courses[i].courseCode + " - " + courses[i].courseName);
        }
    }
}

public class TeacherStudentAssignment1 {
    public static void main(String[] args) {

        Student.students[0] = new Student("Dan Ashley Reyes", 19, "Male", 202411345);
        Student.students[1] = new Student("Johnwel Hinaloc", 20, "Male", 202411274);
        Student.students[2] = new Student("Aaron Ilawan", 14, "Male", 202411776);
        Course course1 = new Course("DCIT 50", "Object-Oriented Programming");
        Course course2 = new Course("COSC 55A", "Discrete Structures 2");
        Course course3 = new Course("COSC 60B", "Digital Logic Design");
       Course course4 = new Course("INSY 50", "Fundamentals of Information System");
        Course course5 = new Course("DCIT 24A", "Information Management");

        Course[] t1Courses = { course1, course3 };
        Course[] t2Courses = { course4, course2 };
        Course[] t3Courses = { course5 };
        Course[] allCourses = { course1, course2, course3, course4, course5 };

        Teacher.teachers[0] = new Teacher("Johnroe Paulo ", 36, "Male", "Computer Science", t1Courses);
        Teacher.teachers[1] = new Teacher("Dredd Tria", 48, "Female", "Computer Science", t2Courses);
        Teacher.teachers[2] = new Teacher("Patrick Tombucon", 55, "Male", "Computer Science", t3Courses);

        Person.students = Student.students;
        Person.teachers = Teacher.teachers;
        Person.displayInfo();
        Student.displayStudents();
        Teacher.displayTeachers();
        Course.displayCourses(allCourses);
    }
}
