import java.util.*;

class NodeData {
	
	int value;
	int dist;
	
	NodeData(int value,int dist){
		this.value = value;
		this.dist = dist;
	}

	
}

public class Dijkstra_Ninjas {
	
	class Graph{
		ArrayList<ArrayList<NodeData>> g;
		int V;
		
		Graph(int V){
			this.V = V;
			this.g = new ArrayList<>();
			for(int i=0; i<V; i++)
				g.add(new ArrayList<>());
		}
		
		public void addEdge(int a, int b, int dist) {
			g.get(a).add(new NodeData(b,dist));
			g.get(b).add(new NodeData(a,dist));
		}
		
		public void dijkstra(int src) {
			int[] visited = new int[this.V];
			int[] dist = new int[this.V];
			for(int i=0; i<this.V; i++)
				dist[i] = Integer.MAX_VALUE;
			dist[src] = 0;
			
			dijkstra_util(src,dist,visited);
			display(dist);
		}
		
		public void dijkstra_util(int src, int[] dist,int[] visited) {
			
			if(src==-1)
				return;
			
			visited[src] = 1;
			for(NodeData c : this.g.get(src)) {
				if(dist[src]+c.dist<dist[c.value])
					dist[c.value] = dist[src]+c.dist; 
			}
			
			int mindist = Integer.MAX_VALUE;
			int index = -1;
			for(int i=0; i<this.V; i++) {
				if(visited[i]==0 && dist[i]<mindist) {
					mindist = dist[i];
					index = i;
				}
			}
			dijkstra_util(index, dist, visited);
			
		}
		
		public void display(int[] arr) {
			for(int c:arr) {
				System.out.print(c+", ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Dijkstra_Ninjas().new Graph(5);
		g.addEdge(0, 1, 4);
		g.addEdge(1, 3, 5);
		g.addEdge(0, 2, 8);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 3, 5);
		g.addEdge(2, 4, 9);
		g.addEdge(3, 4, 4);
		
		g.dijkstra(0);
		
		g = new Dijkstra_Ninjas().new Graph(9);
		g.addEdge(0, 1, 4);
		g.addEdge(2, 1, 8);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, 9);
		g.addEdge(4, 5, 10);
		g.addEdge(6, 5, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(0, 7, 8);
		g.addEdge(7, 8, 7);
		g.addEdge(6, 8, 6);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 5, 14);
		g.addEdge(7, 1, 11);
		

			
		g.dijkstra(0);

	}

}
