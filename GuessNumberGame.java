// Khushi Shah
// Task 2: Guess number game

import java.util.Random;
import java.util.Scanner;

class Guess {
    int randomNumber;
    int range;
    int userNum;
    public int guessnum = 0;
    public int oldGuessnum = 0;
    int round = 0;
    int score;
    boolean winStatus = false;
    Scanner sc = new Scanner(System.in);

    void generateRandomNumber() {
        Random rd = new Random();
        randomNumber = rd.nextInt(this.range + 1);
    }

    void getRange() {
        System.out.println("Enter range");
        int rg = sc.nextInt();
        this.range = rg;
    }

    void takeUserInput() {
        System.out.println("Enter your number..");
        // System.out.println("generated number is: "+randomNumber);
        this.userNum = sc.nextInt();
        this.setNoOfGuesses();
    }

    boolean isCorrectNum() {
        if (guessnum <= 3) {
            if (this.userNum == this.randomNumber) {
                
                winStatus = true;
                return true;
            }

            else if (this.userNum > this.randomNumber) {
                System.out.println("Number is too big");
                if (guessnum != 3) {
                    System.out.println("Enter number again");
                    this.userNum = sc.nextInt();
                }
                this.setNoOfGuesses();
                this.isCorrectNum();
            }

            else if (this.userNum < this.randomNumber) {
                System.out.println("Number is too small");
                if (guessnum != 3) {
                    System.out.println("Enter number again");
                    this.userNum = sc.nextInt();
                }
                this.setNoOfGuesses();
                this.isCorrectNum();
            }
        }
        else{
            winStatus = false;
            }
        return winStatus;
    }

    void setNoOfGuesses() {
        this.guessnum += 1;
        // this.oldGuessnum += this.guessnum;

    }

    int getNoOfGuesses() {
        return this.guessnum;
    }

    int getScore() {
        
            // System.out.println("in getScore method oldGuessnum: "+this.oldGuessnum);      
            this.score = 500-25 * (this.oldGuessnum-1);
            System.out.println("in getScore method score: "+this.score);

        
        return this.score;
    }

}

public class GuessNumberGame {

    public static void main(String[] args) {
        Guess gu = new Guess();
        boolean winOrLoose = false;
        int round = 0;
        boolean status = true;

        while (winOrLoose == false) {

            while(status == true){
                gu.getRange();
                gu.generateRandomNumber();
                status = false;
            }
            gu.takeUserInput();
            winOrLoose = gu.isCorrectNum();
            // int noOfGuess = gu.getNoOfGuesses();

            if (winOrLoose == true) {
                gu.oldGuessnum += gu.guessnum;
                gu.guessnum = 0;
                System.out.println("Correct Number!!");
                System.out.println("No of guesses: " + (gu.oldGuessnum-1));
                System.out.println("Your score is: " + gu.getScore());
                System.exit(1);
            }
            round += 1;
            gu.oldGuessnum += gu.guessnum;
            gu.guessnum = 0;
            System.out.println("Round "+round+ " is completed..");
            // System.out.println("No of guesses: " + gu.oldGuessnum);

            if (round >= 3) {
                System.out.println("All 3 rounds are completed..\nYou loose the game!");
                System.exit(1);
            }
        }

        
    }
}
