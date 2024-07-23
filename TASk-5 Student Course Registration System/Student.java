
import java.util.ArrayList;

class Student {
    private String name;
    private int id;
    private int age;
    private String dob;
    private String password;
    private ArrayList<Courses> registred_courses = new ArrayList<>();
    public Student(String name, int id, int age, String dob, String password) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.dob = dob;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }
    public void add_Course(Courses course) {//registred_course
        registred_courses.add(course);
    }
    public void remove_Course(Courses course) {
        registred_courses.remove(course);
    }
    public ArrayList<Courses> getStudentCourses() {
        return this.registred_courses;
    }

    @Override
    public String toString() {
        System.out.println("#########################      STUDENT DETAILS      #######################");
        System.out.println();
        System.out.println("Student Name               : " +this.name );
        System.out.println("Student Id                 : "+this.id);
        System.out.println("Stident Age                : "+this.age);
        System.out.println("Student Date Of Birth      : "+this.dob);
        System.out.println();
        System.out.println();
        System.out.println("#########################      COURSE DETAILS        #######################");
        System.out.println();
        if(this.registred_courses.size() == 0) {
            System.out.println("                No courses have been Registered.");
        }
        else {
            for(Courses course : this.registred_courses) {
                //System.out.println(course);
                System.out.println("[  Course code : "+course.getCourse_code() + ", Course_Title : " + course.getCourse_titlle()+ "  ]");
            }
        }
        System.out.println();
        System.out.println("#############################################################################");
        return "";
    }
}
