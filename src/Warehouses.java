import java.util.Scanner;


public class Warehouses {

	public static void main(String[] args) {
		long[] amount = new long[3];
		Scanner in = new Scanner(System.in);
		long A = in.nextInt();
		long B = in.nextInt();
		long C = in.nextInt();
		amount[0] = A;
		amount[1] = B;
		amount[2] = C;
		boolean flag = true;
		while(flag){
			int nextMoveFrom = max(amount);
			int nextMoveTo2 = min(amount);
			int nextMoveTo = second(nextMoveFrom,nextMoveTo2);
			print(nextMoveFrom,nextMoveTo);
			amount[nextMoveTo] = amount[nextMoveTo] + amount[nextMoveTo];
			amount[nextMoveFrom] = amount[nextMoveFrom] - amount[nextMoveTo];
			boolean finished = done(amount);
			if(finished){
				System.out.println("D");
				flag = false;
			}
		}
	}
	public static void print(long from,long to){
		String start,end;
		if(from==0) start="A";
		else if(from==1) start="B";
		else start="C";
		
		if(to==0) end="A";
		else if(to==1) end="B";
		else end="C";
		
		System.out.println(start+" "+end);
		
	}
	
	public static int max(long[] arr){
		int max=0;
		if(arr[0]>=arr[1] && arr[0]>=arr[1]){
			return 0;
		}
		if(arr[1]>=arr[0] && arr[1]>=arr[2]){
			return 1;
		}
		
		return 2;
	}
	
	public static int second(int max,int min){
		for(int x=0;x<3;x++){
			if(x==max || x==min) continue;
			else return x;
		}
		return 0;
		
	}
	
	public static int min(long[] arr){
		int max=0;
		if(arr[0]<=arr[1] && arr[0]<=arr[1]){
			return 0;
		}
		if(arr[1]<=arr[0] && arr[1]<=arr[2]){
			return 1;
		}
		
		return 2;
	}
	
	public static boolean done(long[] arr){
		for(long num: arr){
			if(num==0){
				return true;
			}
		}
		return false;
	}
}
