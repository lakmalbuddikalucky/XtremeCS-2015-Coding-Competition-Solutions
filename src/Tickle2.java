import java.math.BigInteger;
import java.util.Scanner;


public class Tickle2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int m = in.nextInt();
		//String numbers[] = new String[N];
		String numbers = "";
		String used = "";
		for(int x=0;x<N;x++){
			numbers=numbers+"_";
			used+="f";
		}
		
		
		
		for(int x=0;x<m;x++){
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			numbers = numbers.substring(0,num2)+String.valueOf(num1)+numbers.substring(num2+1);
			used = used.substring(0,num2)+"t"+used.substring(num2+1);
		}
		
		/*for(String item: numbers){
			System.out.println(item+" ");
		}
		System.out.println();*/
		
		int index=0;
		int indexC = index;
		boolean flag=true;
		for(int x=0;x<N;x++){
			System.out.println(numbers+" "+used);
			index=indexC;
			flag=true;
			String answer = String.valueOf(used.charAt(x));
			if(answer.equals("f")){
				for(int y=index;y<N;y++){
					if(x==y){
						indexC=0;
						flag=false;
						continue;
					}
					
					if(String.valueOf(numbers.charAt(y)).equals("_")){
						//numbers[y] = String.valueOf(x);
						numbers = numbers.substring(0,y)+String.valueOf(x)+numbers.substring(y+1);
						used = used.substring(0,y)+"t"+used.substring(y+1);
						if(flag==true) indexC++;
						break;
					}
					
				}
				
			}
		}
		
		
		System.out.println(numbers);
		System.out.println(convert(numbers,N));
		
	}
	
	public static int convert(String s,int from){
		int sum = 0;
		int length = s.length();
		for(int x=0;x<length;x++){
			int ans = (int) Math.pow(from,length-x-1);
			sum = (sum%1000000007 + (Integer.valueOf(s.substring(x,x+1))*ans)%1000000007)%1000000007;
		}
		return sum;
	}
}
