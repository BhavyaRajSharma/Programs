package hackerrank.preparation.interview.arcesium;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
public class MaximumSubarraySum
{
    static long maximumSum(long[] a, long m) {
        TreeSet<Long> prefixSum=new TreeSet<>();
        int size=a.length;
        long maxSum=0;
        long sum=0;
        Long tempSum=null;
        for(int i=0;i<size;i++){
            if(maxSum==m-1)
                return maxSum;
            sum=(sum+a[i])%m;
            tempSum=prefixSum.higher(sum);
            prefixSum.add(sum);
            if(tempSum==null){
                if(sum>maxSum){
                    maxSum=sum;
                }
            }
            else {
                tempSum=(sum-tempSum+m)%m;
                if(tempSum>maxSum){
                    maxSum=tempSum;
                }
            }
        }
        return maxSum;
    }
}
