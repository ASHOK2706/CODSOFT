import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Question {
    private String question;
    private HashMap<Integer,String> options = new HashMap<>();
    private int answer;
    private static int n = 1;
    public Question(String question, String option1, String option2, String option3,int answer) {
        this.question = question;
        options.put(1, option1);
        options.put(2, option2);
        options.put(3, option3);
        this.answer = answer;
    }
    public int getAnswer() {
        return this.answer;
    }
    @Override
    public String toString() {
        System.out.println("\nQuestion :"+(n++)+". "+ question +"\n");
        for(Map.Entry<Integer,String> it : options.entrySet()) {
            System.out.println(it.getKey() +""+ it.getValue());
        } 
        return "";   
    }
}

class QuestionSet {
    private ArrayList<Question> questions = new ArrayList<>();
    private HashMap<String,String> quiz_summary = new HashMap<>();
    private int Mark=0;
    private int n = 0;
    private boolean timeUp = false;
    private Scanner scan = new Scanner(System.in);

    public QuestionSet() {
        System.out.println("\n#################################   QUIZ TEST   #################################\n");
        showInstructions();
        add_questions();
        // StartQuiz();
    }
    public void StartQuiz() {
        for(int i=0;i<questions.size();i++) {
            askQuestion(questions.get(i));
        }
    }

    public void askQuestion(Question q) {
        n++;
        System.out.println(q);

        timeUp = false;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("\nTime's Up!!!    Press Enter to go next Question");
                store_answer(0,q,n);
            }
        }, 10000); // 10 seconds timer

        String answer = "";
        while (!timeUp && answer.equals("")) {
            System.out.print("Enter Your Answer ( 1 | 2 | 3 ): ");
            if (scan.hasNextLine()) {
                answer = scan.nextLine();
                if (timeUp) {
                    break;
                }
                if (answer.matches("[1-3]")) {
                    timer.cancel();
                    store_answer(Integer.parseInt(answer),q,n);
                } else {
                    System.out.println(" Invalid input. Please enter a number between 1 and 3.");
                    answer = "";
                }
            }
        }
        if(timeUp) {
            timer.cancel();
        }
        System.out.println();
    }


    private void store_answer(int answer,Question q,int n) {
        if(answer==q.getAnswer()) {
            Mark += 1;
            quiz_summary.put("Question "+n, "Correct");
        }
        else {
            quiz_summary.put("Question "+n, "Wrong");
        }
    }

    public void Quiz_Summary() {
        System.out.println();
        System.out.println("##########      QUIZ RESULT      ##########\n\n");
        for(Map.Entry<String,String> it : quiz_summary.entrySet()) {
            System.out.println("             "+it.getKey()+" : "+ it.getValue());
        }

        System.out.println("\n             Your Score : "+ Mark +" / 5\n\n");
    }

    private void add_questions() {

        questions.add(new Question("Which of the following is the correct way to declare a Multidimensional array in Java?",
            ") int[] arr;",
            ") int arr[[]];", 
            ") int[][]arr;",
            3));

        questions.add(new Question("Number of primitive data types in Java are ? ",
            ") 6",
            ") 7", 
            ") 8",
            3));

        questions.add(new Question("When an array is passed to a method, what does the method receive ? ",
            ") The Referencr of the array",
            ") a copy of array", 
            ") a copy of array",
            1));

        questions.add(new Question("___________ is used to find and fix bugs in the Java programs.",
            ") JVM",
            ") JDK", 
            ") JDB",
            3));

        questions.add(new Question(" What is the return type of the hashCode() method in the Object class ? ",
            ") Object",
            ") int", 
            ") long",
            2));
    }
    public void showInstructions() {
        System.out.println("                                QUIZ INSTRUCTIONS :");
        System.out.println("                                ===================\n");
        System.out.println("    1. The quiz consists of multiple-choice questions.");
        System.out.println("    2. Each question has a time limit of 10 seconds.");
        System.out.println("    3. You need to select the correct option (1, 2, or 3) for each question.");
        System.out.println("    4. If you don't select an option, press Enter to skip to the next question.\n");
        System.out.println("##################################################################################\n");
    }
}
public class QuizApplication {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        QuestionSet quiz = new QuestionSet(); 
        while(true) {
            System.out.println("\n 1. Start Quiz");
            System.out.println(" 2. Exit\n");

            System.out.print("Enter Your Option : ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    quiz.StartQuiz();
                    quiz.Quiz_Summary();
                    System.exit(0);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option \n\n");
                    break;
            }
        }
    }
}