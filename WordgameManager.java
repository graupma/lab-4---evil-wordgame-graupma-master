import java.util.Collection;
import java.util.Set;
import java.util.*;

public class WordgameManager {
    
    private int length;
    private int maxGuesses;
    private Set<String> words;
    private Set<Character> setGuesses; 
    private String pattern;

    
    //constructs a set with all the words of the dictionary of the length, and initializes max guesses and the pattern to ----
   public WordgameManager(Collection<String> dictionary, int len, int max){

        
length=len;
maxGuesses=max;

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






    


//returns the set of words in the current dictionary 
    public Set<String> words(){
return words;
    }

//returns number of guesses left
    public int guessesLeft(){
        return maxGuesses;
    } 

//returns the set of characters that have been guessed 
    public Set<Character> guesses(){
        return setGuesses; 
    }


//returns the pattern or null if it is empty 
    public String pattern(){
       if(words==null){
       throw new IllegalArgumentException(); 
       }

        return pattern;
    }
//takes guess and calculates which pattern with that letter has most options and then picks that one. returns num of instances of guess in the picked pattern 
    public int record(char guess){
        if(maxGuesses<1 || words.isEmpty()){
            throw new IllegalStateException();
        }
setGuesses.add(guess);

        Map<String, Set<String>> m= new TreeMap<>(); 
int max=0;
String maxKey="";
String tempWord="";
        for(String s: words){
    tempWord=pattern;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == guess){
                    tempWord= tempWord.substring(0, i) + guess + tempWord.substring(i+1); 
                }

            }

            if(m.containsKey(tempWord)){
                m.get(tempWord).add(s);
            }
            else{
                m.put(tempWord, new TreeSet<>());
                m.get(tempWord).add(s);
            }
                //find biggest set
            if(m.get(tempWord).size()> max){
                max=m.get(tempWord).size();
                maxKey=tempWord; 
            }
            
        }
        
   pattern= maxKey;     
words= m.get(maxKey);
int count=0;
for(int i=0; i< pattern.length(); i++){
    if(pattern.charAt(i)==guess){
        count++;
    }
    
}
if(count==0)
maxGuesses--;

        return count;
    }
}
