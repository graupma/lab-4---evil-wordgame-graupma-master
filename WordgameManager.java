import java.util.Collection;
import java.util.Set;
import java.util.*;

public class WordgameManager {
    
    private int length;
    private int maxGuesses;
    private int guesses;
    private Set<String> set;

    
    
   public WordgameManager(Collection<String> dictionary, int len, int max){

        
length=len;
maxGuesses=max;
guesses=0;
set= new TreeSet<>();

if(length<1 || max<0){
    throw new IllegalArgumentException();
    }

    for(String s : dictionary){
        if(s.length()== length){
            set.add(s);
        }
    }




    }






    



    public Set<String> words(){
return set;
    }


    public int guessesLeft(){
        return maxGuesses-guesses;
    } 


    public Set<Character> guesses(){
        return null;
    }



    public String pattern(){
        return null;
    }

    public int record(char guess){
        return 0;
    }
}
