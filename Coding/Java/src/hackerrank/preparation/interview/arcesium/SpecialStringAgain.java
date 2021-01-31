package hackerrank.preparation.interview.arcesium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class SpecialStringAgain
{
    static long substrCount(int n, String s) {
        long count=0;
        long ccount=0;
        long p1count=0;
        long p2count=0;
        char p1ch='\0';
        char p2ch='\0';
        char ch=s.charAt(0);
        for(int i=0;i<n;){
//            System.out.print(s.charAt(i)+" ");
            if(ch==s.charAt(i)){
                ccount++;
                if(p1count==1 && ch==p2ch && p2count>=ccount){
                    count+=1;
                }
                i++;
            }
            else{
//                System.out.println("["+p2ch+","+p2count+"] "+"["+p1ch+","+p1count+"] "+"["+ch+","+ccount+"]"+" count = "+(count+ccount));
                p2count=p1count;
                p2ch=p1ch;
                p1count=ccount;
                p1ch=ch;
                count+=(ccount*(ccount+1))/2;
                ccount=0;
                ch=s.charAt(i);
            }

        }
        p2count=p1count;
        p2ch=p1ch;
        p1count=ccount;
        p1ch=ch;
        count+=(ccount*(ccount+1))/2;
        ccount=0;
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println(substrCount(5,"asasd"));
//        for(String s:list){
//            System.out.print(s+" ");
//        }
    }
}
