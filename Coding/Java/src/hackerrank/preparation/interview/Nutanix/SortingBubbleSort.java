package hackerrank.preparation.interview.Nutanix;
public class SortingBubbleSort
{
    static void countSwaps(int[] a) {
        int n=a.length;
        int swapCount=0;
        int temp;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swapCount++;
                }
            }

        }
        System.out.println("Array is sorted in "+swapCount+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
    }
}
