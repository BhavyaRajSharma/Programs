package hackerrank;
import java.util.Scanner;
public class LeftRotation
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int d=scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int[] result=getArrayAfterRotation(arr,n,d);
        for(int i:result)
            System.out.print(i+" ");
    }
    private static int[] getArrayAfterRotation(int[] arr, int size, int noRotations)
    {
        noRotations=noRotations%size;
        int[] rotArr = new int[size];
        int i=0;
        while(i<size){
            rotArr[i]=arr[(noRotations+i)%size];
            i++;
        }
        return rotArr;
    }
}
