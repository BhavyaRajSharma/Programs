package hackerrank.preparation.interview.arcesium;
import java.util.HashMap;
public class RansomNote
{
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String,Integer> wordmap=new HashMap<>();
        for(String word:magazine){
            wordmap.put(word,wordmap.getOrDefault(word,0)+1);
        }
        for(String word:note){
            if(!wordmap.containsKey(word)){
                System.out.println("No");
                return;
            }
            else{
                wordmap.put(word,wordmap.get(word)-1);
                if(wordmap.get(word)==0){
                    wordmap.remove(word);
                }
            }
        }
        System.out.println("Yes");
    }
}
