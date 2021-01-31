package google.codinginterview;
import java.util.HashSet;
import java.util.Set;
public class TripletSum
{
    private static String sortAndGetString(int a, int b, int c){
        String triplet="";
        if(a<b){
            if(a<c){
                if(b<c){
                    triplet=a+","+b+","+c;
                }
                else{
                    triplet=a+","+c+","+b;
                }
            }
            else{
                    triplet=c+","+a+","+b;
            }
        }
        else{
            if(b<c){
                if(a<c){
                    triplet=b+","+a+","+c;
                }
                else{
                    triplet=b+","+c+","+a;
                }
            }
            else{
                triplet=c+","+b+","+a;
            }
        }
        return triplet;
    }
    public static Set<String> getTriplets(int[] arr, int sum){
        int size=arr.length;
        Set<String> tripletList = new HashSet<>();
        int[] countBucketPositive=new int[1000_000];
        int[] countBucketNegative=new int[1000_000];
        for(int i=0;i<size;i++){
            if(arr[i]>=0)
                countBucketPositive[arr[i]]++;
            else
                countBucketNegative[-1*arr[i]]++;
        }
        int indexSum=0;
        String triplet="";
        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                indexSum=sum-arr[i]-arr[j];
                if(indexSum>=0){
                    if(countBucketPositive[indexSum]>0){
                        tripletList.add(sortAndGetString(arr[i],arr[j],indexSum));
                    }
                }
                else{
                    if(countBucketNegative[-1*indexSum]>0){
                        tripletList.add(sortAndGetString(arr[i],arr[j],indexSum));
                    }
                }
            }
        }
        return tripletList;
    }
    public static void main(String[] args)
    {
        Set<String> result=getTriplets(new int[]{-1,0,1,2,-1,-4},0);
        System.out.print("[ ");
        for(String triplet:result){
            System.out.print(" [ "+triplet+" ]");
        }
        System.out.print(" ]");
    }
}
