import java.util.*;

class GraphSP{
	int V;
	ArrayList<ArrayList<Integer>> arr;
	
	GraphSP(int V){
		this.V = V;
		this.arr = new ArrayList<>();
		for(int i=0; i<V; i++)
			arr.add(new ArrayList<>());
	}
	
	public void add_edge(int v1, int v2) {
		
		this.arr.get(v1).add(v2);
		this.arr.get(v2).add(v1);
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
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}

public class ShortestPathUnweightedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphSP g = new GraphSP(8);
		
		g.add_edge(0, 1);
		g.add_edge(0, 3);
		g.add_edge(1, 2);
		g.add_edge(3, 7);
		g.add_edge(3, 4);
		g.add_edge(4, 7);
		g.add_edge(7, 6);
		g.add_edge(4, 6);
		g.add_edge(5, 6);
		g.add_edge(4, 5);
		
		//g.display();
		//System.out.println(g.bfs(0,7,8));
		g.shortest_path(2,6);
		
		
		

	}

}
