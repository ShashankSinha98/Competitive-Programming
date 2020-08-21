import java.util.*;
import java.io.*;

class SnakeGraphGFG{
	int V;
	ArrayList<ArrayList<Integer>> arr;
	int shortestDist = 0;
	
	SnakeGraphGFG(int V){
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
		
		/*for(int i=res.size()-1; i>=0; i--) {
			System.out.print(res.get(i)+" , ");
		}*/
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


public class SnakeLadderGfg {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t--!=0) {
			
			int n = Integer.parseInt(br.readLine());
			String[] strarr = br.readLine().split("\\s+");
			int[] board = new int[50];
			
			for(int i=0; i<strarr.length; i+=2) {
				int a = Integer.parseInt(strarr[i]);
				int b = Integer.parseInt(strarr[i+1]);			
				board[a] = b-a;
			}
			
			
			SnakeGraphGFG g = new SnakeGraphGFG(31);
			
			for(int i=1;i<=30; i++) {
				for(int dice = 1; dice<=6; dice++) {
					
					int j = i+dice;
					j += board[j];
					
					if(j<=30) {
						g.add_edge(i, j);
					}
				}
			}
			
			//g.display();
			g.shortest_path(1, 30);
			System.out.println(g.shortestDist);
			
		}
		

	}

}
