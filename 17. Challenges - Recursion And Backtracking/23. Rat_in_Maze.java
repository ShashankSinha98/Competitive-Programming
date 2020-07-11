import java.util.*;
public class Rat_in_Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int m = s.nextInt();
		int n = s.nextInt();
		
		char[][] maze = new char[m][n];
		
		for(int i=0;i<m;i++) {
			String str = s.next();
			for(int k=0;k<str.length();k++) {
                char cc=str.charAt(k);
                maze[i][k] = cc;
            }
			
		}
		int[][] sol = new int[m][n];
		Boolean res = rat_in_maze(maze,sol,0,0,m-1,n-1);
		if (!res) {
			System.out.println("-1");
		}
		

	}
	
	static Boolean rat_in_maze(char[][] maze, int[][] sol, int i, int j, int m, int n) {
		
		if (i==m && j==n) {
			sol[i][j] = 1;
			for(int r=0;r<=m;r++) {
				for(int c=0; c<=n; c++) {
					System.out.print(sol[r][c]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if (i>m || j>n) {
			return false;
		}
		
		if (maze[i][j]=='X') {
			return false;
		}
		
		sol[i][j] = 1;
		
		boolean right_success = rat_in_maze(maze, sol, i, j+1, m, n);
		boolean left_success = rat_in_maze(maze, sol, i+1, j, m, n);
		
		sol[i][j]=0;

		if (right_success || left_success)
			return true;
		
		return false;
		
		
	}
	
	
	
	static void display(char[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}
	}

}
