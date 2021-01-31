package hackerrank.preparation.interview.Nutanix;
import java.util.*;
public class IceCreamParlor
{
    static void whatFlavors(int[] cost, int money) {
        int size=cost.length;
        HashMap<Integer, Queue<Integer>> costList=new HashMap<>();
        Queue<Integer> tempList;
        for(int i=0;i<size;i++){
            tempList=costList.getOrDefault(cost[i],new LinkedList<>());
            tempList.add(i);
            costList.put(cost[i],tempList);
        }
        int value;
        for(int i=0;i<size;i++){
            costList.get(cost[i]).poll();
            tempList=costList.get(money-cost[i]);
            if(tempList!=null && !tempList.isEmpty()){
                System.out.println((i+1)+" "+(tempList.poll()+1));
            }
        }
    }
}
