import java.util.*;
public class Topological_Sort_Using_DFS {

	class Graph{
		int V;
		HashMap<String, ArrayList<String>> map;
		
		public Graph(int V,ArrayList<String> arr) {
			this.V = V;
			this.map = new HashMap<>();
			
			for(String s : arr) {
				this.map.put(s, new ArrayList<>());
			}
			
		}
		
		
		public void add_edge(String v1, String v2) {
			if(this.map.containsKey(v1))
				this.map.get(v1).add(v2);
			else {
				ArrayList<String> list = new ArrayList<>();
				list.add(v2);
				this.map.put(v1,list);
			}
		}
		
		public void topological_sort() {
			HashMap<String,Boolean> visited = new HashMap<>();
			for(String key : this.map.keySet()) {
				visited.put(key, false);
			}
			
			
			LinkedList<String> order = new LinkedList<>();
			
			for(String key : this.map.keySet()) {
				if(!visited.get(key)) {
					dfs_helper(key,visited,order);
				}
			}
			
			for(String i : order) {
				System.out.print(i+" -> ");
			}
			System.out.println();
		}
		
		public void dfs_helper(String node, HashMap<String,Boolean> visited, LinkedList<String> order) {
			
			visited.put(node, true);
			
			
			for(String c : this.map.get(node)) {

				if(!visited.get(c)) 
					dfs_helper(c, visited, order);
			}
			order.addFirst(node);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> nodes = new ArrayList<>();
		nodes.add("Python");
		nodes.add("Data Preprocessing");
		nodes.add("Pytorch");
		nodes.add("ML Basics");
		nodes.add("Deep Learning");
		nodes.add("Dataset");
		nodes.add("Face Recognition");
		
		Graph g = new Topological_Sort_Using_DFS().new Graph(7,nodes);
		
		
		
		g.add_edge("Python", "Data Preprocessing");
		g.add_edge("Python", "Pytorch");
		g.add_edge("Data Preprocessing", "ML Basics");
		g.add_edge("Pytorch","Deep Learning");
		g.add_edge("Dataset", "Face Recognition");
		g.add_edge("Deep Learning", "Face Recognition");
		g.add_edge("ML Basics", "Deep Learning");
		
		g.topological_sort();

	}

}
