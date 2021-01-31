package hackerrank;
import java.util.Scanner;
public class TwoDArrayDS
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                arr[i][j]=scan.nextInt();
            }
        }
        System.out.println(calculateMaxHourglassSum(arr,6,6));
    }
    private static long calculateMaxHourglassSum(int[][] arr, int row, int col)
    {
        long hourglassSum=0;
        long maxHourglassSum=Long.MIN_VALUE;
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                hourglassSum=arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1]+arr[i][j]+arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
                if(hourglassSum>maxHourglassSum)
                    maxHourglassSum=hourglassSum;
            }
        }
        return maxHourglassSum;
    }
}
