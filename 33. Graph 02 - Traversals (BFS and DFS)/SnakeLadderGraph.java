import java.util.*;

class SnakeGraph{
	int V;
	ArrayList<ArrayList<Integer>> arr;
	int shortestDist = 0;
	
	SnakeGraph(int V){
		this.V = V;
		this.arr = new ArrayList<>();
		for(int i=0; i<V; i++)
			arr.add(new ArrayList<>());
	}
	
	public void add_edge(int v1, int v2) {
		this.arr.get(v1).add(v2);
	}
	
	public void display() {
		for(int i=0; i<this.V; i++) {
			System.out.print(i+"");
			ArrayList<Integer> list = this.arr.get(i);
			
			for(int j : list) {
				System.out.print(" -> "+j);
			}
			System.out.println();
		}
	}
	
	public void shortest_path(int src,int dest) {
		int[] pred = new int[this.V];
		
		if(! bfs(src,dest,this.V,pred))
			return;
		
		ArrayList<Integer> res = new ArrayList<>();
		res.add(dest);
		int temp = dest;
		
		while(pred[temp]!=-1) {
			res.add(pred[temp]);
			temp = pred[temp];
		}
		
		for(int i=res.size()-1; i>=0; i--) {
			System.out.print(res.get(i)+" , ");
		}
	}
	
public boolean bfs(int src, int dest, int v,int[] pred) {
		
		Queue<Integer> q = new LinkedList<>();
		int dist[] = new int[v];
		boolean[] visited = new boolean[v];
		//int[] pred = new int[v];
		
		for(int i=0; i<v; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
			pred[i] = -1;
		}
		
		q.add(src);
		visited[src] = true;
		dist[src] = 0;
		
		while(!q.isEmpty()) {
			//System.out.println(q);
			int curr = q.remove();
			ArrayList<Integer> list = this.arr.get(curr);
			
			for(int i : list) {
				if(visited[i]==false) {
					dist[i] = dist[curr]+1;
					pred[i] = curr;
					visited[i] = true;
					q.add(i);
				}
				
				if(i==dest) {
					this.shortestDist = dist[i];
					return true;
				}
			}
		}
		return false;
	}
	
		
}


public class SnakeLadderGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SnakeGraph g = new SnakeGraph(37); 
		
		int[] board = new int[50];
		board[2] = 13;
		board[5] = 2;
		board[9] = 18;
		board[18] = 11;
		board[17] = -13;
		board[20] = -14;
		board[24] = -8;
		board[25] = 10;
		board[32] = -2;
		board[34] = -22;
		
		for(int i=0; i<=36; i++) {
			for(int dice=1; dice<=6; dice++) {
				int j = i+dice;
				j += board[j];
				
				if(j<=36) {
					g.add_edge(i, j);
				}
			}
		}
		
		//g.display();
		
		g.shortest_path(0,36);
		System.out.println();
		System.out.println("Shortest Dist : "+g.shortestDist);
		
		

	}

}
