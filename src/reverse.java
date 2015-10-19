import java.util.Scanner;


public class reverse {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		String qStr = String.valueOf(q);
		int length=  qStr.length();
		String k = "1";
		for(int x=0;x<length;x++){
			k = k+"0";
		}
		length = Integer.valueOf(k);
		boolean flag = false;
		for(int x=1;x<length*1;x++){
			String reversed = new StringBuilder(String.valueOf(x)).reverse().toString();
			int num1 = Integer.valueOf(reversed);
			//System.out.println(x+" "+num1);
			if(x-num1==q){
				System.out.println(x);
				flag = true;
				break;
			}
		}
		if(flag==false) System.out.println("NONE");
	}
}
