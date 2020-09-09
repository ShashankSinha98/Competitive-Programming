import java.util.*;
public class Topological_sort_using_BFS {
	
	class Graph{
		
		ArrayList<ArrayList<Integer>> arr;
		int V;
		
		Graph(int V){
			this.V =V;
			this.arr = new ArrayList<>();
			for(int i=0;i<V;i++) {
				arr.add(new ArrayList<>());
			}
		}
		
		public void add_edge(int x, int y) {
			this.arr.get(x).add(y);
		}
		
		public void display() {
			
			for(int i=0; i<V; i++) {
				System.out.print(String.valueOf(i));
				
				for(int j=0;j<this.arr.get(i).size(); j++) {
					System.out.print(" -> "+this.arr.get(i).get(j));
				}
				System.out.println();
			}
		}
	
		
		public void topological_sort() {
			
			int[] indegree = new int[this.V];
			
			for(int i=0;i<this.V; i++) {
				for(int c : this.arr.get(i)) {
					indegree[c]+=1;
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			for(int i=0; i<this.V; i++) {
				if(indegree[i]==0)
					q.add(i);
			}
			
			System.out.println(q);
			while(!q.isEmpty()) {
				int removed = q.remove();
				System.out.print(removed+" -> ");
				for(int c : this.arr.get(removed)) {
					if(indegree[c]>0)
						indegree[c]-=1;
					
					if(indegree[c]==0) {
						q.add(c);
					}
				}
				
			}
		}
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Topological_sort_using_BFS().new Graph(6);
		
		g.add_edge(0, 2);
		g.add_edge(1, 2);
		g.add_edge(1, 4);
		g.add_edge(2, 3);
		g.add_edge(2, 5);
		g.add_edge(4, 5);
		g.add_edge(3, 5);
		
		g.topological_sort();
	}

}
