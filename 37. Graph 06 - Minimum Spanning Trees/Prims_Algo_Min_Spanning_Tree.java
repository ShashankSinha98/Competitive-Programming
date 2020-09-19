import java.util.*;


class Node2 implements Comparator<Node2>{
	
	int a,b,cost;
	
	Node2(){}
	
	Node2(int a,int b,int cost){
		this.a = a;
		this.b =b;
		this.cost = cost;
	}
	

	@Override
	public int compare(Node2 node1, Node2 node2) {
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
		return "("+a+","+b+")";
	}
	
}



public class Prims_Algo_Min_Spanning_Tree {
	
		class Graph{
		HashMap<Integer, ArrayList<NodeData>> g;
		int V;
		
		Graph(int V){
			this.V = V;
			g = new HashMap<>();
			
			for(int i=0; i<V; i++)
				g.put(i,new ArrayList<>());
		}
		
		void addEdge(int a, int b, int w) {
			this.g.get(a).add(new NodeData(b, w));
			this.g.get(b).add(new NodeData(a, w));
		}
		
		void display() {
			for(int k : this.g.keySet()) {
				System.out.println(k+" -> "+g.get(k));
			}
		}
	
		
		int min_spanning_tree(int src) {
			
			int ans=0;
			
			PriorityQueue<Node2> pq = new PriorityQueue<>(new Node2());
			
			HashSet<Integer> visited = new HashSet<>();
			visited.add(src);
			while(visited.size() != this.V) {
				
				for(NodeData c : this.g.get(src)) {
					if(!visited.contains(c.value)) {
						pq.add(new Node2(src, c.value, c.dist));
					}
				}
				System.out.println(pq);
				Node2 minNode = pq.poll();
				int min = minNode.cost;
				
				
				if(!visited.contains(minNode.b)) {
					src = minNode.b;	
					ans += min;
					visited.add(src);
				}
			}
			
			return ans;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String[] arr = s.nextLine().split("\\s+");
		int N = Integer.valueOf(arr[0]);
		int M = Integer.valueOf(arr[1]);
		
		Graph g = new Prims_Algo_Min_Spanning_Tree().new Graph(N);
		
		for(int i=0; i<M; i++) {
			arr = s.nextLine().split("\\s+");
			int a = Integer.valueOf(arr[0]);
			int b = Integer.valueOf(arr[1]);
			int w = Integer.valueOf(arr[2]);
			
			g.addEdge(--a, --b, w);
		}
		
		// g.display();

		System.out.println(g.min_spanning_tree(0));

	}

}
