import java.util.Collection;
import java.util.Set;
import java.util.*;

public class WordgameManager {
    
    private int length;
    private int maxGuesses;
    private int guesses;
    private Set<String> words;
    private Set<Character> setGuesses; 
    private String pattern;

    
    
   public WordgameManager(Collection<String> dictionary, int len, int max){

        
length=len;
maxGuesses=max;
guesses=0;
words= new TreeSet<>();
setGuesses= new TreeSet<>(); 

if(length<1 || max<0){
    throw new IllegalArgumentException();
    }

    for(String s : dictionary){
        if(s.length()== length){
            words.add(s);
        }
    }

    pattern="";
    for(int i=0; i<length; i++){
        pattern+="-";
    }




    }






    



    public Set<String> words(){
return words;
    }


    public int guessesLeft(){
        return maxGuesses-guesses;
    } 


    public Set<Character> guesses(){
        return setGuesses; 
    }



    public String pattern(){
       if(words==null){
       throw new IllegalArgumentException(); 
       }

        return pattern;
    }

    public int record(char guess){
        if(guesses<1 || words.isEmpty()){
            throw new IllegalStateException();
        }

        Map<String, Set<String>> m= new TreeMap<>(); 

        for(String s: words){
            String tempWord=pattern; 
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == guess){
                    tempWord= tempWord.substring(0, i) + guess + tempWord.substring(i); 
                }

            }

            if(m.containsKey(tempWord)){
                m.get(tempWord).add(s);
            }
            else{
                m.put(tempWord, new TreeSet<>());
                m.get(tempWord).add(s);
            }
        }
        //loop through and figure out which set is the most
int big=0;
        for(String t: m.keySet() ){
            
        }

        return 0;
    }
}
