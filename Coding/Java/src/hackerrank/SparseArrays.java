package hackerrank;
import java.util.HashMap;
import java.util.Scanner;
public class SparseArrays
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for(int i=0;i<n;i++){
            strings[i]=scanner.nextLine();
        }
        int q= scanner.nextInt();
        scanner.nextLine();
        String[] queries=new String[q];
        for(int i=0;i<q;i++){
            queries[i]=scanner.nextLine();
        }
        int[] result=getQueriesOccurenceCountInString(n,strings,q,queries);
        for(int i:result)
            System.out.println(i);
    }
    private static int[] getQueriesOccurenceCountInString(int stringSize, String[] strings, int querySize, String[] queries)
    {
        int[] occurenceCount=new int[querySize];
        HashMap<String,Integer> occurenceCountMap = new HashMap<>();
        for(int i=0;i<stringSize;i++){
            occurenceCountMap.put(strings[i],occurenceCountMap.getOrDefault(strings[i],0)+1);
        }
        for(int i=0;i<querySize;i++){
            occurenceCount[i]=occurenceCountMap.getOrDefault(queries[i],0);
        }
        return occurenceCount;
    }
}
