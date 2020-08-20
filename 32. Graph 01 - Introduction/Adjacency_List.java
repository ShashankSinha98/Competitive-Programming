import java.util.*;

class Graph{
	
	
	int V;
	ArrayList<ArrayList<Integer>> arr;
	
	Graph(int V){
		this.V = V;
		this.arr = new ArrayList<>();
		for(int i=1; i<=V; i++)
			this.arr.add(new ArrayList<>());
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
	
	
}


public class Adjacency_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		Graph g = new Graph(4);
		g.add_edge(0, 1);
		g.add_edge(0, 2);
		g.add_edge(2, 3);
		g.add_edge(1, 2);
		
		g.display();
		
	}

}
