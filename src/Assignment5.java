
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author malij6756
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // loops for the request at the end to "play again" where it will break if the player doesn't want to play anymore
        while(true){
        
        // instructs player 1 to enter a word
        System.out.println("Player 1: Enter a word for Player 2 to guess:");

        // creates scanner then stores word inputted as "word"
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();

        // creates spaces
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("   ");

        // takes the length of the word, then converts it into dashes, stored as "dashes"
        int length = word.length();
        String dashes = "";
        for (int i = 0; i < length; i++) {
            dashes = dashes + "-";
        }
        // prints out dashes for player 2
        System.out.println(dashes);
        
        // sets the lives as 6 and the number of right letters to fill in as the length of the word
        int right = length;
        int lives = 6;
        
        // while the lives are more than 0, and not all of the letters are guessed, follow this loop
        while(right > 0 && lives > 0) {
       
        // prints out instructions for player 2
        System.out.println("Player 2: You have " + lives +  " lives left. Guess a letter:");

        // stores the guess by player 2 as "guess" then stores it as a char
        String guess = input.nextLine();
        char letter = guess.charAt(0);
        
        // creates an integer for the letter, if below 0 then that letter is not in the word
        // if it is above 0, then it gives the location of the letter in the word, stores it as letterPos
        int letterPos = word.indexOf(letter);

       // if the letter is guessed right
       if (letterPos >= 0) {
           // while there is another occurance of the letter in the word
           while(letterPos >= 0) {
            // takes the first half of the dashes before the letter
            String firstHalf = dashes.substring(0, letterPos);
            // takes the back half of the dashes after the letter
            String backHalf = dashes.substring(letterPos + 1, length);
            
            // rearranges the word so the letter guessed right is rearranged
            dashes = firstHalf + letter + backHalf;
            
           
           
           
           
           // takes the first half of the word before the letter
            String firstHalf2 = word.substring(0, letterPos);
            // takes the back half of the word after the letter
            String backHalf2 = word.substring(letterPos + 1, length);
           
            // rearranges word with the first occurance of the letter replaced with "*"
            word = firstHalf2 + "*" + backHalf2;
           
           // searches for anotehr occurance of the letter after the first which was replaced
            letterPos = word.indexOf(letter,letterPos + 1 );
            
            // removes 1 from "right" which is the variable that decides when all letters have been guessed
            right = right - 1;
            
           }
           
           System.out.println("You guessed the right letter!");
            
            // converts the answer to uppercase
            dashes = dashes.toUpperCase();
         
            // prints out the word with the right letter included
            System.out.println(dashes);
            
            
            
        } else {
           
           System.out.println("Sike, wrong letter!");
           
           // if the letter guessed is wrong, then remove 1 life and go back to the start of the program
           lives = lives - 1;
       } 
        }
        // if the player guesses the word right, they get a win message
       if (lives > 0) {
          System.out.println("Congratulations, you won!");
       } 
       // if the player lost then they're given a loss message
       else if(lives == 0) {
           System.out.println("You have lost!");
           System.out.println("The word was " + word);
       }
      
       // asks if player wants to play again, stores answer as "playagain"
       System.out.println("Would you like to play again? (Yes or No)");
       String playagain = input.nextLine();
       
       // if the player says "No" then break from the loop
        if(playagain.equals("No")) {
            break;
        }
    }
    }


    }

