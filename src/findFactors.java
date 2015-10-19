import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Lakmal Buddika Meegahapola
 *
 */
public class findFactors {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		for(int x=0;x<250;x++){
			if(isPrime(x)==true){
				System.out.print(x+" ");
			}
		}
		
	     
	     
	     
	}
	
	public static boolean isPrime(long n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public static long factorial(int num){
		if(num==1){
			return 1;
		}
		else{
			long output = factorial(num-1)*num;
			return output;
		}
	}
	
	
	

}
