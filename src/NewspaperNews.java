import java.util.Scanner;


public class NewspaperNews {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String lane1 = in.next();
		String lane2 = in.next();
		int length = lane1.length();
		int count=0;
		boolean[] marked = new boolean[length+1];
		for(int x=0;x<length;x++){
			String sub1_1 = lane1.substring(x,x+1);
			String sub2_1 = lane2.substring(x,x+1);
			if(sub1_1.equals("T")||sub2_1.equals("T")){
				marked[x]=true;
				count+=1;
			}
		}
		
		
		
		for(int y=0;y<length;y++){
			if(y==0){
				if(marked[y]==true){
					continue;
				}
				else{
					if(marked[y+1]==false){
						marked[y]=true;
						count+=1;
					}
				}
			}
			else if(y==length-1){
				if(marked[y]==true){
					continue;
				}
				else{
					if(marked[y-1]==false){
						marked[y]=true;
						count+=1;
					}
				}
			
			}
			else{
				if(marked[y]==true){
					continue;
				}
				else{
					if(marked[y-1]==false && marked[y+1]==false){
						marked[y]=true;
						count+=1;
					}
				}
				
			}
		}
		
		System.out.println(count);

	}

}
