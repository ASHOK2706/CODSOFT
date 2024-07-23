import java.util.ArrayList;
import java.util.Scanner;

class Student_Operations {
    private ArrayList<Student> studentdb = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private static int id = 0;
    private CourseRegistration courese_registration;
    public Student_Operations() {
        initialize();
        this.courese_registration = new CourseRegistration();
    }
    public void login() {
        System.out.println("-------------------------------------------------");
        System.out.println("                STUDENT LOGIN");
        System.out.println("-------------------------------------------------\n\n");
        boolean check = true;
        Student current_student = null;
        while(check) {
            System.out.print("Enter Your Username : ");
            String name = scan.nextLine();
            scan.nextLine();
            System.out.print("Enter Your Password : ");
            String pass = scan.next();
            scan.nextLine();
            current_student = ChechDetails(name,pass);
            if(current_student != null)  {
                System.out.println();
                System.out.println("     LOGIN SUCCESSFULL !!!\n");
                studentAccount(current_student);
                check = false;
            }
            else {
                System.out.println("\nInvalid Username or Password  :( \nna");
            }
        }
    }

    public void register() {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("               STUDENT REGISTRATION");
        System.out.println("-------------------------------------------------\n\n");

        System.out.print("Enter Your Name (your Name is username) : ");
        String name = scan.nextLine();
        scan.nextLine();
        System.out.print("Enter Your Age : ");
        int age = scan.nextInt();
        System.out.println();
        System.out.print("Enter Your Date Of Birth (DD-MM-YYYY): ");
        String dob = scan.next();
        scan.nextLine();
        System.out.println();
        System.out.print("Enter Your Password : ");
        String password = scan.next(); 
        scan.nextLine();

        studentdb.add(new Student(name, ++id, age, dob, password));
        System.out.println("\nSTUDENT REGISTRATION SUCCESSFULL !!! \n");
    }
    private Student ChechDetails(String name,String pass) {
        for(Student student : studentdb) {
            if(name.equals(student.getName()) && pass.equals(student.getPassword())) {
                return student;
            }
        }
        return null;
    }

    private void studentAccount(Student current_student) {

        System.out.println("-------------------------------------------------");
        System.out.println("               MY PROFILE");
        System.out.println("-------------------------------------------------");
        System.out.println("NAME : "+ current_student.getName().toUpperCase());
        System.out.println();

        boolean check = true;
        while(check) {
            System.out.println("    1. Show Avaliable Coureses");
            System.out.println("    2. Register Course");
            System.out.println("    3. Drop Course");
            System.out.println("    4. Show Registered Coureses");
            System.out.println("    5. View Profile");
            System.out.println("    6. Logout \n");

            System.out.print("Enter Your Choice : ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    courese_registration.show_avaliable_courses();
                    break;
                case 2:
                    courese_registration.register_course(current_student);
                    break;
                case 3:
                    courese_registration.drop_course(current_student);
                    break;
                case 4:
                    courese_registration.show_registered_courses(current_student);
                    break;
                case 5:
                    courese_registration.view_profile(current_student);
                    break;
                case 6:
                    check=false;
                    break;
                default:
                    System.out.println("Invalid Option   :(  \n");
                    break;
            }

            System.out.println();
        }

    }
    private void initialize() {
        studentdb.add(new Student("name1", ++id, 20, "27-06-2003", "name1@stud"));
        studentdb.add(new Student("name2", ++id, 21, "11-04-2002", "name2@stud"));
        studentdb.add(new Student("name3", ++id, 19, "09-02-2003", "name2@stud"));
        studentdb.add(new Student("name4", ++id, 20, "17-01-2004", "name2@stud"));
        studentdb.add(new Student("name5", ++id, 19, "12-05-2003", "name2@stud"));
    }
}
