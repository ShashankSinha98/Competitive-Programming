import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;



public class KosarajuGFG {

	class KosarajuGraph {

		ArrayList<ArrayList<Integer>> graph;
		ArrayList<ArrayList<Integer>> reverse_graph;
		int V;

		KosarajuGraph(int V) {
			this.V = V;
			this.graph = new ArrayList<>();
			this.reverse_graph = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				graph.add(new ArrayList<>());
				reverse_graph.add(new ArrayList<>());
			}
		}

		public void add_edge(int x, int y) {
			this.graph.get(x).add(y);
			this.reverse_graph.get(y).add(x);
		}

		public int getStronglyConnectedComponents() {
			
			Stack<Integer> st = new Stack<>();
			int[] visited = new int[this.V];
			
			for(int i=0; i<this.V; i++) {
				if(visited[i]==0)
				dfs_helper(i,visited,st);
			}
			
			//System.out.println(st);
			
			visited = new int[this.V];
			
			int col=0;
			while(!st.isEmpty()) {
				int curr = st.pop();
				if(visited[curr]==0) {
					col+=1;
					dfs_mark_components(curr,col,visited);
			}
			}
			
			/*for(int i=0; i<this.V; i++) {
				
				System.out.println(i+" -> "+visited[i]);
			}*/
			//System.out.println("Count : "+col);
			return col;
		}
		
		public void dfs_mark_components(int curr, int col,int[] visited) {
			
			visited[curr] = col;
			
			for(int c : this.reverse_graph.get(curr)) {
				if(visited[c]==0)
					dfs_mark_components(c, col, visited);
			}
			
		}

		public void dfs_helper(int node, int[] visited, Stack<Integer> st) {
			visited[node] = 1;
			for (int c : this.graph.get(node)) {
				if (visited[c] == 0) {
					dfs_helper(c, visited, st);
				}
			}
			st.add(node);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		
		while (t--!=0) {
			
			String[] nm = s.nextLine().split("\\s+");
			int N = Integer.valueOf(nm[0]);
			int M = Integer.valueOf(nm[1]);
			
			String[] arr = s.nextLine().split("\\s+");
			
			KosarajuGraph g = new KosarajuGFG().new KosarajuGraph(N);
			
			for(int i=0;i<M; i++) {
				g.add_edge(Integer.valueOf(arr[2*i]), Integer.valueOf(arr[(2*i)+1]));
			}
			
			int ans = g.getStronglyConnectedComponents();
			System.out.println(ans);
			
		}

	}

}
