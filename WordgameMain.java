// Class WordgameMain is the driver program for the Wordgame program.  It reads a
// dictionary of words to be used during the game and then plays a game with
// the user.  This is a cheating version of wordgame that delays picking a word
// to keep its options open.  You can change the setting for SHOW_COUNT to see
// how many options are still left on each turn.

import java.util.*;
import java.io.*;

public class WordgameMain  {
    public static final String DICTIONARY_FILE = "dictionary.txt";
    public static final boolean SHOW_COUNT = false;  // show # of choices left

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the HHS \"Guess the word\" game.");
        System.out.println();

        // open the dictionary file and read dictionary into an ArrayList
        Scanner input = new Scanner(new File(DICTIONARY_FILE));
        List<String> dictionary = new ArrayList<>();
        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        // set basic parameters
        Scanner console = new Scanner(System.in);
        System.out.print("What length word do you want to use? ");
        int length = console.nextInt();
        System.out.print("How many wrong answers allowed? ");
        int max = console.nextInt();
        System.out.println();

        // set up the WordgameManager and start the game
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        WordgameManager wordgame = new WordgameManager(dictionary2, length, max);
        if (wordgame.words().isEmpty()) {
            System.out.println("No words of that length in the dictionary.");
        } else {
            playGame(console, wordgame);
            showResults(wordgame);
        }
    }

    // Plays one game with the user
    public static void playGame(Scanner console, WordgameManager wordgame) {
        while (wordgame.guessesLeft() > 0 && wordgame.pattern().contains("-")) {
            System.out.println("guesses : " + wordgame.guessesLeft());
            if (SHOW_COUNT) {
                System.out.println("words   : " + wordgame.words().size());
            }
            System.out.println("guessed : " + wordgame.guesses());
            System.out.println("current : " + wordgame.pattern());
            System.out.print("Your guess? ");
            char ch = console.next().toLowerCase().charAt(0);
            if (wordgame.guesses().contains(ch)) {
                System.out.println("You already guessed that");
            } else {
                int count = wordgame.record(ch);
                if (count == 0) {
                    System.out.println("Sorry, there are no " + ch + "'s");
                } else if (count == 1) {
                    System.out.println("Yes, there is one " + ch);
                } else {
                    System.out.println("Yes, there are " + count + " " + ch +
                                       "'s");
                }
            }
            System.out.println();
        }
    }

    // reports the results of the game, including showing the answer
    public static void showResults(WordgameManager wordgame) {
        // if the game is over, the answer is the first word in the list
        // of words, so we use an iterator to get it
        String answer = wordgame.words().iterator().next();
        System.out.println("answer = " + answer);
        if (wordgame.guessesLeft() > 0) {
            System.out.println("You beat me");
        } else {
            System.out.println("Sorry, you lose");
        }
    }
}
