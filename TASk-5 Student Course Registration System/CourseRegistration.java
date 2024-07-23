import java.util.ArrayList;
import java.util.Scanner;

class CourseRegistration {
    private ArrayList<Courses> course_list = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    public CourseRegistration() {
        initialize();
    }
    public void show_avaliable_courses() {//1
        for(Courses course : course_list) {
            System.out.println(course);
        }
    }
    public void register_course(Student current_student) {//2
        System.out.print(" Enter Course Code : ");
        String course_code = scan.next();
        scan.nextLine();
        if(isValidCoursecode(course_code)) {
            Courses course = getCourse(course_code);
            if(isAlreadyEntrolled(course_code,current_student)) {
                System.out.println("You are  Already Entrolled this Course. !!!");
            }
            else if(course!=null && course.getCapacity()!=0) {
                current_student.add_Course(course);
                course.setCapacity(course.getCapacity()-1);
                System.out.println("\n      Course Registred Successfully !!!\n");
            }
            else {

                System.out.println("\n      Course is Not Avaliable   :( ");
            }
        }
        else {
            System.out.println("Invalid Course Code  :(  ");
        }

    }
    public void drop_course(Student current_student) { // 3
        System.out.print(" Enter Course Code to Drop : ");
        String course_code = scan.next();
        scan.nextLine();
        if(isValidCoursecode(course_code)) {
            Courses course = getCourse(course_code);
            if(isAlreadyEntrolled(course_code,current_student)) {
                current_student.remove_Course(course);
                course.setCapacity(course.getCapacity()+1);
                System.out.println("\n      Course Droped Successfully !!!\n");
            }
            else {
                System.out.println("You are not enrolled in this course, so you cannot Remove it.\n");
            }
        }
        else {
            System.out.println("Invalid Course Code  :(  ");
        }
    }
    public void show_registered_courses(Student current_student) { // 4
        System.out.println();
        System.out.println("####################    REGISTERED COURSE DETAILS   ##################");
        System.out.println();
        ArrayList<Courses> student_courses = current_student.getStudentCourses();
        if(student_courses.size()==0) {
            System.out.println("\nNo courses have been Registered.\n");
        }
        else {
            for(Courses course : student_courses) {
                System.out.println("[  Course code : "+course.getCourse_code() + ", Course_Title : " + course.getCourse_titlle()+ "  ]");
            }
        }
    }

    public void view_profile(Student current_student) {
        System.out.println(current_student);
    }

    private Courses getCourse(String course_code) {
        for(Courses course : course_list) {
            if(course.getCourse_code().equals(course_code)) {
                return course;
            }
        }
        return null;
    }

    private boolean isValidCoursecode(String course_code) {
        for(Courses course : course_list) {
            if(course.getCourse_code().equals(course_code)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAlreadyEntrolled(String course_code,Student current_student) {
        ArrayList<Courses> student_courses = current_student.getStudentCourses();
        for(Courses course : student_courses) {
            if(course.getCourse_code().equals(course_code)) {
                return true;
            }
        }
        return false;
    }
    private void initialize() {
        course_list.add(new Courses("C1", "DATABASE MANAGEMENT SYSTEM", 1));
        course_list.add(new Courses("C2", "OBJECT ORIENTED PROGRAMING USING JAVA", 2));
        course_list.add(new Courses("C3", "OPERATING SYSTEM", 1));
        course_list.add(new Courses("C4", "COMPUTER NETWORKING", 5));
        course_list.add(new Courses("C5", "DATA STRUCTURES", 0));
    }
}
