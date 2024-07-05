import java.util.Scanner;
public class StudentGradeCalculatorMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n##############       STUDENT GRADE CALCULATOR       ##############");
        System.out.println();
        System.out.print("Enter Total Number Of Subjects : ");
        int number_of_subject = scan.nextInt();
        int[] ObtainedMarks = new int[number_of_subject];
        System.out.println();
        for(int i=0;i<number_of_subject;i++) {
            System.out.print("Enter Subject "+(i+1)+" Mark : ");
            ObtainedMarks[i] = scan.nextInt();
        }
        int TotalMarks = getTotal(ObtainedMarks);
        double AverageMark = getAverage(TotalMarks,number_of_subject); 
        String grade = calculateGrade(AverageMark);
        displayResult(TotalMarks,AverageMark,grade);

        gradeDescriptionTabel();
    }

    private static int getTotal(int[] obtainedMarks) {
        int total = 0;
        for(int i=0;i<obtainedMarks.length;i++) {
            total += obtainedMarks[i];
        }
        return total;
    }

    private static double getAverage(int totalMarks, int number_of_subject) {
        return (double)(totalMarks/number_of_subject);
    }

    private static String calculateGrade(double averageMark) {
        String grade = "";
        if(averageMark>=90) {
            grade = "A+";
        }
        else if(averageMark>=80 && averageMark<=89.9) {
            grade = "A";
        }
        else if(averageMark>=70 && averageMark<=79.9) {
            grade = "B+";
        }
        else if(averageMark>=60 && averageMark<=69.9) {
            grade = "B";
        }
        else if(averageMark>=50 && averageMark<=59.9) {
            grade = "C+";
        }
        else {
            grade = "Fail";
        }

        return grade;
    }

    private static void displayResult(int totalMarks,double averageMark,String grade) {
        System.out.println("\n");
        System.out.println("Student Total Mark          : "+totalMarks);
        System.out.println("Student Average Percentage  : "+averageMark);
        System.out.println("Student Grade               : "+grade);
        System.out.println("\n");
    }

    private static void gradeDescriptionTabel() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("| Grater than | Between | Between | Between | Between | Less than |");
        System.out.println("|    89.9     | 80-89.9 | 70-79.9 | 60-69.9 | 50-59.9 |     50    |");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("|     A+      |    A    |    B+   |    B    |    C+   |    Fail   |");
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
    }
}