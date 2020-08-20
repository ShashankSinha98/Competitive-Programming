import java.util.*;

class Pair{
	
	String vertex;
	int value;
	
	Pair(String vertex,int value){
		this.vertex = vertex;
		this.value = value;
	}
	
}


class WeightedGraph{
	
	HashMap<String, ArrayList<Pair>> map;
	
	public WeightedGraph() {
		// TODO Auto-generated constructor stub
		this.map = new HashMap<>();
	}
	
	public void add_edge(String v1, String v2, boolean isBidirectional, int weight) {
		ArrayList<Pair> list;
		if(isBidirectional) {
			
			
			if (! this.map.containsKey(v1)) 
				list = new ArrayList<>();
			 else 
				list = this.map.get(v1);
			
			list.add(new Pair(v2,weight));
			this.map.put(v1,list);
			
			if (! this.map.containsKey(v2)) 
				list = new ArrayList<>();
			 else 
				list = this.map.get(v2);
			
			
			list.add(new Pair(v1,weight));
			this.map.put(v2,list);
			
		} else {
			
			if (! this.map.containsKey(v1)) 
				list = new ArrayList<>();	
			else 
				list = this.map.get(v1);
			
			list.add(new Pair(v2,weight));
			this.map.put(v1,list);
		}
		
	}

	
	public void display() {
		
		for(Map.Entry mapElement : this.map.entrySet()) {
			
			String key = (String) mapElement.getKey();
			ArrayList<Pair> value = (ArrayList<Pair>) mapElement.getValue();
			
			System.out.print(key);
			
			for(Pair p : value) {
				System.out.print(" -> ("+p.vertex+", "+p.value+" )");
			}
			System.out.println();
		}
	}
}


public class Weighted_Adjacency_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WeightedGraph g = new WeightedGraph();
		
		g.add_edge("A", "B", true, 20);
		g.add_edge("B", "D", true, 30);
		g.add_edge("C", "D", true, 40);
		g.add_edge("A", "C", true, 10);
		g.add_edge("A", "D", false, 50);
		
		g.display();

	}

}
