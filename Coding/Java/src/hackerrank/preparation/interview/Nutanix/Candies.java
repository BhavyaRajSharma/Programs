package hackerrank.preparation.interview.Nutanix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Candies
{
    static long candies(int n, int[] arr)
    {
        long candiesCount = 2;
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        List<Integer> candiesList = new ArrayList<>();
        candiesList.add(arr[j--]);
        boolean pickBig = false;
        while (i <= j)
        {
            if (pickBig)
            {
                if (j >= 0 && j>=i)
                {
                    candiesList.add(0, arr[j--]);
                    candiesCount+=2;
                }
                if (j >= 0 && j>=i)
                {
                    candiesList.add(arr[j--]);
                    candiesCount+=2;
                }
                pickBig=false;
            }
            else{
                if(i<n && i<=j)
                {
                    candiesList.add(0, arr[i++]);
                    candiesCount+=1;
                }
                if(i<n && i<=j)
                {
                    candiesList.add(arr[i++]);
                    candiesCount+=1;
                }
                pickBig=true;
            }
        }
        for(Integer integer:candiesList){
            System.out.print(integer+" ");
        }
        System.out.println();

        return candiesCount;
    }

}
