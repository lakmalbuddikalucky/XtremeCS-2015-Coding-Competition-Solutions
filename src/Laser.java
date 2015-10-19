import java.util.Scanner;


public class Laser {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int rows = in.nextInt();
			int colomns = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			char[][] grid = new char[rows+1][colomns+1];
			boolean[][] gridBool = new boolean[rows+1][colomns+1];
			for(int k=0;k<x;k++){
				int yCor = in.nextInt();
				int xCor = in.nextInt();
				grid[yCor][xCor] = '/';
				gridBool[yCor][xCor]=true;
			}
			
			for(int k=0;k<y;k++){
				int yCor = in.nextInt();
				int xCor = in.nextInt();
				grid[yCor][xCor] = '_';
				gridBool[yCor][xCor]=true;
			}
			
			boolean flag = true;
			int indexX=1;
			int indexY=1;
			int down = 0;
			int right = 1;
			int up = 0;
			int left = 0;
			while(flag && indexY<rows && indexY>=1 && indexX<colomns && indexX>=1){
				if(grid[indexY][indexX]=='_'){
					right=0;
					down = 1;
					if(down==1)	indexY++;
				}
				else if(grid[indexY][indexX]=='/'){
					
				}
			}
		}

	}

}
