/**
 * Created by Donasia "Dojo" Brown
 * Project: GuessTheMovie
 * Date: 8/18/2022
 * Time: 19:17
 * Title: Guess The Movie Game
 */
import java.util.Scanner;

public class GuessTheMovie {
    public static void main (String [] args) throws Exception {
        //Create Movie Picker
        MoviePicker moviePicker = new MoviePicker();

        //Start game
        boolean keepPlaying = true;
        int wins = 0;
        int losses = 0;
        while (keepPlaying) {
            //Pick a Random Movie for the Answer
            String answer = moviePicker.pickAMovie();

            // Create Initial Gameboard
            String [] movieCharacters = answer.split("");
            String gameBoard = "";
            int numLetters = 0;
            for (int j = 0; j < answer.length(); j++) {
                if (movieCharacters[j].equals(" ") || movieCharacters[j].equals("'") || movieCharacters[j].equals("-")) {
                    gameBoard += movieCharacters[j];
                } else {
                    gameBoard += "_";
                }
            }

            // Collect progress
            int incorrectGuesses = 0;
            int maxIncorrectGuesses = 10;
            boolean gameOver = false;
            boolean gameWon = false;
            String guesses = "";

            // Initiate scanner for collecting guesses
            Scanner scanner = new Scanner(System.in);

            //Introduce the Game
            System.out.println("Welcome to Guess the Movie!");
            System.out.println("Wins: " + wins + " | Losses: " + losses);

            // Continue game until Game Won or Game Over
            while (!gameWon & !gameOver){
                // Display game rules
                System.out.println("You are guessing: " + gameBoard);
                System.out.println("Incorrect guesses: " + incorrectGuesses);
                System.out.println("Guesses made: " + guesses);
                System.out.println("Guess a letter: ");
                String myGuess;

                // Guess a Letter
                while (true) {
                    myGuess = scanner.nextLine();

                    // Check if letter has already been guessed
                    if (guesses.indexOf(myGuess) < 0) {
                        guesses += myGuess;
                        break;
                    } else {
                        System.out.println("You already guessed that letter. Guess again:");
                    }
                }

                // Check for Letter
                String [] gameBoardCharacters = gameBoard.split("");
                int letterPosition = answer.indexOf(myGuess);
                if (letterPosition >= 0) {
                    // Clear the game board and replace the characters accordingly
                    gameBoard = "";
                    for (int i = 0; i < answer.length(); i++) {
                        if (movieCharacters[i].equals(myGuess)) {
                            gameBoardCharacters[i] = myGuess;
                        }
                        gameBoard += gameBoardCharacters[i];
                    }
                    if (gameBoard.indexOf("_") < 0){
                        gameWon = true;
                    }
                } else {
                    System.out.println("Nope! Sorry. Try Again.");
                    incorrectGuesses ++;
                }

                if (incorrectGuesses >= maxIncorrectGuesses){
                    gameOver = true;
                }
                System.out.println();
            }

            // Display the answer
            if (gameOver){
                losses ++;
                System.out.println("GAME OVER! The movie was \"" + answer + "\"!");
            } else if (gameWon){
                wins ++;
                System.out.println("YOU WIN! The movie was \"" + answer + "\"!");
            }

            // Play Again?
            System.out.println("Would you like to play again? (y or n) ");
            String playAgain = scanner.nextLine();
            if (playAgain.equals("y") || playAgain.equals("Y")){
                keepPlaying = true;
            } else {
                keepPlaying = false;
                System.out.println("Wins: " + wins + " | Losses: " + losses);
            }
            System.out.println();
        }
        // End Program
        System.out.println("Thank you for playing!");
    }
}
