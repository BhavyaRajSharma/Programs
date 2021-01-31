package hackerrank;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class MedianUpdates
{
    private static List<Long> valueList=new ArrayList<>();
    private static int medianIndex=0;
    private static int size=0;
    private static String addValue(Long value){
        if(size==0){
            valueList.add(0,value);
            size++;
            return value+"";
        }
        int i=-1;
        for(i=0;i<size;i++){
            if(valueList.get(i)>=value){
                valueList.add(i,value);
                size++;
                break;
            }
        }
        if(i==size){
            valueList.add(i,value);
            size++;
        }
        String median=size%2==0? String.format("%.0f",((valueList.get(size/2)+valueList.get(size/2-1))/2.0)) : String.format("%.0f",(double)(valueList.get(size/2-1)));
        return (median+"").replaceAll("\\.?0*$", "");
    }
    private static String removeValue(Long value){
        for(int i=0;i<size;i++){
            if(valueList.get(i)==value){
                valueList.remove(i);
                size--;
                break;
            }
        }
        if(size==1){
            return valueList.get(0)+"";
        }
        String median=size%2==0? String.format("%.0f",((valueList.get(size/2)+valueList.get(size/2-1))/2.0)) : String.format("%.0f",(double)(valueList.get(size/2-1)));
        return (median+"").replaceAll("\\.?0*$", "");
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        while (n-- > 0)
        {
            System.out.println("-------------------------------------------");
            System.out.print(size+"[");
            for(Long i:valueList){
                System.out.print(i+" ");
            }
            System.out.println("]");
            String[] line = scanner.nextLine().split(" ");
            String operation = line[0];
            Long value = Long.valueOf(line[1]);
            if (operation.equals("a"))
            {
                System.out.println(addValue(value));
            }
            else
            {
                if (valueList.contains(value))
                {
                    if (size > 1)
                        System.out.println(removeValue(value));
                    else
                        System.out.println("Wrong!");
                }
                else
                {
                    System.out.println("Wrong!");
                }
            }
        }
    }

}
