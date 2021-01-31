package codechef.divison3.JanuaryCookOff2021;
import java.util.Scanner;
public class Password
{
    public static boolean checkPassword(String password){
        int[] check=new int[4];
        char[] special=new char[]{'@','#','%','&','?'};
        int size=password.length();
        if(size<10 || password.charAt(0)<'a' || password.charAt(0)>'z' || password.charAt(size-1)<'a' || password.charAt(size-1)>'z')
            return false;
        check[0]=1;
        for(int i=1;i<size-1;i++){
            char ch=password.charAt(i);
            if(ch>='a' && ch<='z')
                continue;
            if(ch>='A' && ch<='Z')
            {
                check[1]=1;
                continue;
            }
            if(ch>='0' && ch <='9'){
                check[2]=1;
                continue;
            }
            switch (ch){
                case '@':
                case '#':
                case '%':
                case '&':
                case '?': check[3]=1;continue;
            }
            return false;
        }
        for(int i=0;i<4;i++){
            if(check[i]==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            if(checkPassword(scanner.nextLine())){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
