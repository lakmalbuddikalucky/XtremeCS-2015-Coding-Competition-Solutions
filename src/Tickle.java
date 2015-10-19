import java.math.BigInteger;
import java.util.Scanner;


public class Tickle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int m = in.nextInt();
		String numbers[] = new String[N];
		//String numbers = "";
		for(int x=0;x<N;x++){
			numbers[x]="-1";
		}
		
		
		
		boolean used[] = new boolean[N];
		for(int x=0;x<m;x++){
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			numbers[num2]=String.valueOf(num1);
			used[num1]=true;
		}
		
		/*for(String item: numbers){
			System.out.println(item+" ");
		}
		System.out.println();*/
		
		int index=0;
		int indexC = index;
		boolean flag=true;
		for(int x=0;x<N;x++){
			for(String item: numbers){
				System.out.println(item+" ");
			}
			System.out.println();
			index=indexC;
			flag=true;
			boolean answer = used[x];
			if(answer==false){
				for(int y=index;y<N;y++){
					if(x==y){
						indexC=0;
						flag=false;
						continue;
					}
					if(numbers[y].equals("-1")){
						numbers[y] = String.valueOf(x);
						if(flag==true) indexC++;
						break;
					}
					
				}
				
			}
		}
		String answer = "";
		for(String item: numbers){
			answer = answer + item;
		}
		
		/*System.out.println(answer);
		String answer2 = Integer.toString(Integer.parseInt(answer, N),10);
		BigInteger ans = new BigInteger(answer2);
		BigInteger mod = new BigInteger("1000000007");
		ans = ans.mod(mod);*/
		System.out.println(convert(answer,N));
		
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
