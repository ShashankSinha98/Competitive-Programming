import java.util.*;


class Node implements Comparator<Node>{
	int data;
	int cost;
	
	
	public Node() {}
	
	public Node(int data, int cost) {
		this.data = data;
		this.cost = cost;
	}


	@Override
	public int compare(Node node1, Node node2) {
		// TODO Auto-generated method stub
		if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.data+","+this.cost+")";
	}
}

public class Dijkstra_PQ {
	
	class Graph{
		ArrayList<ArrayList<Node>> g;
		int V;
		
		Graph(int V){
			this.V = V;
			g = new ArrayList<>();
			for(int i=0; i<this.V; i++)
				g.add(new ArrayList<>());
		}
		
		public void addEdge(int a, int b,int dist) {
			this.g.get(a).add(new Node(b,dist));
			this.g.get(b).add(new Node(a,dist));
		}
		
		public void dijkstra(int src) {
			int[] dist = new int[this.V];
			
			for(int i=0; i<this.V; i++)
				dist[i] = Integer.MAX_VALUE;
			dist[src] = 0;
			
			PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
			pq.add(new Node(src,0));
			
			HashSet<Integer> visited = new HashSet<>();
			
			while(visited.size()!=this.V) {
				
				int curr = pq.remove().data;
				visited.add(curr);
				
				visitNeighbors(curr,visited,dist,pq);
				
				
			}
			
			for(int d : dist) {
				System.out.print(d+", ");
			}
			System.out.println();
			System.out.println(pq);
		}
		
		public void visitNeighbors(int curr,HashSet<Integer> visited,int[] dist,PriorityQueue<Node> pq) {
			
			for(Node c : this.g.get(curr)) {
				
				if(!visited.contains(c.data)) {
					
					if(dist[curr]+c.cost<dist[c.data]) {
						dist[c.data] = dist[curr]+c.cost;
						pq.add(new Node(c.data,dist[c.data]));
					}
					
					
					
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Dijkstra_PQ().new Graph(5);
		
		g.addEdge(0, 1, 4);
		g.addEdge(1, 3, 5);
		g.addEdge(0, 2, 8);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 3, 5);
		g.addEdge(2, 4, 9);
		g.addEdge(3, 4, 4);
		
		g.dijkstra(0);
		
		g = new Dijkstra_PQ().new Graph(9);
		
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
