//Jeremy Hansen 
package hang.man;

import java.util.Random;
import java.util.Scanner;

public class HangMan
{

    //Will contain the guesses that the user has.
    private static char[] wordToGuess;
    // This will check the random words length to be set to the wordToGuess[]
    private static int wordLength;
    // temporarily store the random word for the user to guess.
    private static String guessWord;

    private static char[] dash;

    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static char usersGuess;

    private static boolean gameOver = false;

    private static String[] words =
    {
        "nintendo", "xbox", "playstation", "atari", "commodore"
    };

    private static String testWord;
    private static int count = 0;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        //random nextInt(5) Will return a number 0-4.
        int num = rand.nextInt(5);

        //guessWord is being assigned a random String from the [] words
        guessWord = words[num];

        wordLength = guessWord.length();
        dash = new char[wordLength];
        dash = guessWord.toCharArray();

        dashArray(guessWord);

        while ((7 - count) != 0 && gameOver != true)
        {
            int numberOfGuesses = 0;
            printGallows();
            System.out.println(" ");
            printAlphabet(dash);

            wordToGuess = explode(guessWord);

            System.out.println("\nPlease enter a letter for the game");
            usersGuess = input.nextLine().charAt(0);
            updateAlphabet(usersGuess);
            wordToGuess = guessWord.toCharArray();
            for (int i = 0; i < wordToGuess.length; i++)
            {
                if (wordToGuess[i] == usersGuess)
                {
                    dash[i] = usersGuess;
                    testWord = new String(dash);

                }
            }
            for (int i = 0; i < guessWord.length(); i++)
            {

                if (usersGuess != wordToGuess[i])
                {
                    numberOfGuesses++;
                }
            }
            if (numberOfGuesses == wordLength)
            {
                count++;
            }

            System.out.println("You have " + (7 - count) + " guesses left");

            endGame();
        }

        System.out.println((gameOver != true) ? "You lost the game!" : "You won the game!");
        if (count == 7)
        {
            System.out.println("\n-------");
            System.out.println("|     |\t\t");
            System.out.println("|     O");
            System.out.println("|    /|\\");
            System.out.println("|     |");
            System.out.println("|    / \\");
            System.out.println("The correct word is: " + guessWord);
        }

    }

    // Takes in a String uses the method toCharArray(); to convert to a char[]
    public static char[] explode(String s)
    {
        wordLength = s.length();
        wordToGuess = new char[wordLength - 1];
        wordToGuess = s.toCharArray();
        return wordToGuess;
    }

    // Takes in a character array and prints each character with a space.
    public static void printAlphabet(char[] c)
    {

        for (int i = 0; i < c.length; i++)
        {

            System.out.print(c[i] + " ");

        }
        System.out.println(" ");

    }
//
    public static char[] dashArray(String s1)
    {
        dash = new char[wordLength];
        for (int i = 0; i < dash.length; i++)
        {
            dash[i] = '_';

        }
        return dash;
    }

    // This method will remove letters in the alphabet and replace with a dash.
    public static char[] updateAlphabet(char guess)
    {
        for (int i = 0; i < alphabet.length; i++)
        {
            if (alphabet[i] == (guess))
            {
                alphabet[i] = '_';

            }
            System.out.print("" + alphabet[i] + " ");
        }
        System.out.println("");

        return alphabet;
    }
// This method prints the gallows for the user.
// if the users input is incorrect it will display HANG MAN.
    public static void printGallows()
    {

        System.out.println("\n-------");
        System.out.println("|     |\t\t");

        if (count == 1)
        {
            System.out.println("|     O");
        }

        if (count == 2)
        {
            System.out.println("|     O");
            System.out.println("|     |");
        }
        if (count == 3)
        {
            System.out.println("|     O");
            System.out.println("|    /|");
        }
        if (count == 4)
        {
            System.out.println("|     O");
            System.out.println("|    /|\\");
        }
        if (count == 5)
        {
            System.out.println("|     O");
            System.out.println("|    /|\\");
            System.out.println("|     |");
        }
        if (count == 6)
        {
            System.out.println("|     O");
            System.out.println("|    /|\\");
            System.out.println("|     |");
            System.out.println("|    /");
        }

        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        printAlphabet(alphabet);

    }

    public static boolean endGame()
    {

        if (guessWord.equals(testWord))
        {
            gameOver = true;
            return gameOver;
        }
        return gameOver;
    }

}
