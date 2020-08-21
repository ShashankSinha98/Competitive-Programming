import java.util.*;

class GraphBFS{
	
	Map<Object,ArrayList<Object>> map;
	
	GraphBFS(){
		this.map = new HashMap<>();
	}
	
	public void add_edge(Object v1, Object v2) {
		
		ArrayList<Object> list;
		
		if(map.containsKey(v1))
			list = map.get(v1);
		else
			list = new ArrayList<>();
		list.add(v2);
		this.map.put(v1, list);
		
		if(map.containsKey(v2))
			list = map.get(v2);
		else
			list = new ArrayList<>();
		list.add(v1);
		this.map.put(v2, list);
	}
	
	public void bfs(Object src) {
		Queue<Object> q = new LinkedList<>();
		Map<Object,Boolean> visited = new HashMap<>();
		
		q.add(src);
		visited.put(src, true);
		
		
		while(!q.isEmpty()) {
			//System.out.println(q);
			Object curr_item = q.remove();
			System.out.println(curr_item);
			
			ArrayList<Object> list = this.map.get(curr_item);
			
			for(Object o : list) {
				if(!visited.containsKey(o) || !visited.get(o)) {
					q.add(o);
					visited.put(o, true);
				}
			}
		}
		
	}
	
}

public class BFS_Traversal_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphBFS g = new GraphBFS();
		
		g.add_edge(0, 1);
		g.add_edge(0, 3);
		g.add_edge(1, 2);
		g.add_edge(2, 3);
		g.add_edge(3, 4);
		g.add_edge(4, 5);
		
		g.bfs(0);

	}

}
