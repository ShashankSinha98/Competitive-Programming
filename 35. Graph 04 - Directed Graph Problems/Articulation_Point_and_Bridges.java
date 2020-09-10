import java.util.*;


public class Articulation_Point_and_Bridges {
	
	class Pair{
		int a,b;
		
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{"+String.valueOf(this.a)+", "+String.valueOf(this.b)+"}";
		}
	}
	
class Graph{
		
	
		Set<Integer> articulation_points;
		ArrayList<ArrayList<Integer>> arr;
		ArrayList<Pair> bridges;
		int V;
		
		Graph(int V){
			this.V =V;
			this.arr = new ArrayList<>();
			articulation_points = new HashSet<>();
			bridges = new ArrayList<>();
			for(int i=0;i<V;i++) {
				arr.add(new ArrayList<>());
			}
		}
		
		public void add_edge(int x, int y) {
			this.arr.get(x).add(y);
			this.arr.get(y).add(x);
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


		public void points_bridges() {
			
			int[] discoverTime = new int[this.V];
			int[] lowestTime = new int[this.V];
			
			int time = 1;
			for(int node=0; node<this.V; node++) {
				if(discoverTime[node]==0) {
					//System.out.println("Time: "+time);
					dfs_helper(node, -1,discoverTime,lowestTime,time);
				}
			}
			
			//display_arr(discoverTime);
			//display_arr(lowestTime);
		}
		
		public void dfs_helper(int curr, int parent,int[] discoverTime, int[] lowestTime, int time) {
			
			int noOfChild = 0;
			discoverTime[curr] = lowestTime[curr] = time;
			time+=1;
			
			for(int child : this.arr.get(curr)) {
				
				if(discoverTime[child]==0) {
					noOfChild+=1;
					
					dfs_helper(child,curr, discoverTime, lowestTime, time);
					lowestTime[curr] = Math.min(lowestTime[curr], lowestTime[child]);
					
					
					if(parent!=-1 && lowestTime[child]>=discoverTime[curr]) {
						// AP exist
						//System.out.println("C: "+curr);
						this.articulation_points.add(curr);
					}
					
					if(lowestTime[child]>discoverTime[curr]) {
						// Bridge exist
						this.bridges.add(new Pair(curr, child));
					}
					
				
				} else if(discoverTime[child]>0 && child != parent) {
					lowestTime[curr] = Math.min(lowestTime[curr], discoverTime[child]);
				}
			}
			
			
			// Separate case for src node
			if(parent==-1 && noOfChild>=2) {
				this.articulation_points.add(curr);
			}
		}

		public void display_arr(int[] arr) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+", ");
			}
			System.out.println();
		}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g1 = new Articulation_Point_and_Bridges().new Graph(5);
		g1.add_edge(0, 1);
		g1.add_edge(1, 2);
		g1.add_edge(2, 0);
		g1.add_edge(2, 3);
		g1.add_edge(3, 4);
		
		g1.points_bridges();
		System.out.println("Points: "+g1.articulation_points);
		System.out.println("Bridges: "+g1.bridges);
		
		System.out.println("**************************************");
		
		Graph g2 = new Articulation_Point_and_Bridges().new Graph(5);
		g2.add_edge(1, 0); 
		g2.add_edge(0, 2); 
		g2.add_edge(2, 1); 
		g2.add_edge(0, 3); 
		g2.add_edge(3, 4);
		
		g2.points_bridges();
		System.out.println("Points: "+g2.articulation_points);
		System.out.println("Bridges: "+g2.bridges);
		
		System.out.println("**************************************");
		
		Graph g3 = new Articulation_Point_and_Bridges().new Graph(4);
		g3.add_edge(0, 1);
		g3.add_edge(1, 2);
		g3.add_edge(2, 3);
		
		g3.points_bridges();
		System.out.println("Points: "+g3.articulation_points);
		System.out.println("Bridges: "+g3.bridges);
		
		System.out.println("**************************************");

		Graph g4 = new Articulation_Point_and_Bridges().new Graph(7);
		g4.add_edge(0, 1); 
        g4.add_edge(1, 2); 
        g4.add_edge(2, 0); 
        g4.add_edge(1, 3); 
        g4.add_edge(1, 4); 
        g4.add_edge(1, 6); 
        g4.add_edge(3, 5); 
        g4.add_edge(4, 5); 
        
		g4.points_bridges();
		System.out.println("Points: "+g4.articulation_points);
		System.out.println("Bridges: "+g4.bridges);
	}

}
