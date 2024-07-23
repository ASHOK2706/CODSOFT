import java.util.Scanner;

public class StudentCourseRegistrationSystemMain {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("                        STUDENT COURSE REGISTRATION");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------\n");

        Student_Operations student_operations = new Student_Operations();

        while (true) {
            System.out.println("        1. LOGIN ");
            System.out.println("        2. REGISTER (if new student)");
            System.out.println("        3. EXIT\n");
            System.out.print("        Enter Your Choice :  "); 
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    student_operations.login();
                    break;
                case 2:
                    student_operations.register();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option Please Enter Between 1 to 3   :(");
                    break;
            }
        }
    }
}