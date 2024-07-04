
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
class GenerateNumber {
    private static int generated_number;
    
    public void Generate(){
        Random random_number = new Random();
        generated_number = random_number.nextInt(100);
        generated_number +=1;
    }

    public static int getGeneratedNumber(){
        return generated_number;
    }
}
class GuessNumber {
    Scanner scan = new Scanner(System.in);
    private static ArrayList<Summary> history = new ArrayList<>();
    private int round;
    private int attempt = 10;

    public GuessNumber(int round) {
        this.round = round;
    }

    public void Guess() {
        while(true) {
            if(attempt==0) {
                System.out.println("\n            Game Over  :( \n");
                break;
            }
            
            System.out.println("\n                                                                  Remaning Attempts :  "+attempt);
            System.out.print("\nGuess the Number within a specified range, such as (1 to 100) : ");
            
            int number = scan.nextInt();
            if(compare(number)) {
                break;
            }
            attempt = attempt-1;
        }
    }

    public boolean compare(int number) {
        int genatated_number = GenerateNumber.getGeneratedNumber();
        if(number==GenerateNumber.getGeneratedNumber()) {
            System.out.println("\n\n            Guess Is Correct !!!\n\n");
            return true;
        }
        else if(number<genatated_number) {
            System.out.println("\n            too Low \n");
            return false;
        }
        else {
            System.out.println("\n            too High \n");
        }
        return false;
    }

    public char Exit() {
        System.out.println("\nDo you want to Exit Game ?\n");
        System.out.println("press -> ' y '  to Exit ");
        System.out.println("press -> ' n ' to I will Play ");
        char ch = scan.next().charAt(0);
        return ch;
    }

    public void setSummary() {
        history.add(new Summary(round, attempt));
    }
    public void getSummary() {
        System.out.println("                ###########      Game Summary        ###########");
        for(Summary summary:history) {
            System.out.println();
            System.out.println(summary);
        }
        System.out.println();
    }
    public void FinalResult() {
        int overallPoints = 0;
        int TotalRounds = 0;
        for(Summary summary:history) {
            overallPoints+=summary.getPoint();
            TotalRounds++;
        }
        System.out.println("Total Number Of Rounds Played : "+TotalRounds);
        System.out.println("Avarage Points                : "+((double)overallPoints/TotalRounds));
        System.out.println("\n");
    }
}

class Summary {
    private int round;
    private int attempt;
    private int point;
    private  String Status;
    public Summary(int round,int attempt) {
        this.round = round;
        this.point = setPoint(attempt);
        this.Status = getStatus(attempt);
        this.attempt = 11-attempt;
    }
    
    private int setPoint(int attempt) {
        int[] points = {0,10,20,30,40,50,60,70,80,90,100};
        return points[attempt];
    }
    private String getStatus(int attempt) {
        if(attempt == 0) {
            return "Loss";
        }
        return "Victory";
    }
    public int getPoint() {
        return this.point;
    }
     @Override
    public String toString() {
        return "[      Round : "+ round + ",  Total Attempt : " + attempt + ",  Point : " + point + ",  Status: " + Status   +"      ]";
    }
}

public class Number_Game_Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GenerateNumber generate = new GenerateNumber();

        System.out.println("\n                      NUMBER GAME\n");
        int Round = 1;
        char ch='n';
        do {
            System.err.println("1. Play  ");
            System.out.println("2. Exit  ");
            System.out.print("Enter Choice ( 1 | 2 ) : ");
            int choice = scan.nextInt();
            GuessNumber play = new GuessNumber(Round++);
            switch(choice) {
                case 1:
                    //GuessNumber play = new GuessNumber();
                    generate.Generate();
                    play.Guess();
                    play.setSummary();
                    break;
                case 2:
                    ch = play.Exit();
                    if(ch=='y') {
                        play.getSummary();
                        play.FinalResult();
                    }
                    break;
                default:
                    System.out.println("    Invalid Choice  :(  ");
                    break;
            }
        }while(ch=='n');
    }
}

