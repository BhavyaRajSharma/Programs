package hackerrank.preparation.interview.arcesium;
import java.util.Comparator;
public class SortingComparator
{
}
class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player>
{
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score==b.score)
        {
            int size=a.name.length()>b.name.length()?b.name.length():a.name.length();
            for(int i=0;i<size;i++){
                if(a.name.charAt(i)==b.name.charAt(i)){
                    continue;
                }
                return a.name.charAt(i)-b.name.charAt(i);
            }
            return a.name.length()-b.name.length();
        }
        return b.score-a.score;
    }
}
