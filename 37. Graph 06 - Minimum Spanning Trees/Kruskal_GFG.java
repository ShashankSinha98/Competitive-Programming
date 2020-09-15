import java.util.*;

class Edge {
	int w,a,b;
	
	Edge(int w, int a, int b){
		this.w = w;
		this.a = a;
		this.b = b;
	}
	
	public int getWeight() {
		return this.w;
	}
	
	public int getA() {
		return this.a;
	}
	public int getB() {
		return this.b;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(a:"+a+",b:"+b+",w:"+w+")";
	}
}

    class DSU{
		int[] parent;
		int[] size;
		int noOfComponents;
		int V;
		
		DSU(int V){
			this.V = V;
			noOfComponents = V;
			parent = new int[V];
			size = new int[V];
			
			for(int i=0; i<V; i++) {
				parent[i] = i;
				size[i] = 1;  
			}
		}

		public int get_superparent(int x) {
			
			if(this.parent[x]==x)
				return x;
			
			else return parent[x] = get_superparent(parent[x]);
		}
		
		public void union(int x, int y) {
			int superparent_x = get_superparent(x);
			int superparent_y = get_superparent(y);
			if(superparent_x != superparent_y) {
				this.parent[superparent_x] = superparent_y;
				this.noOfComponents-=1;
				this.size[superparent_y] += this.size[superparent_x];
				// this.size[superparent_x] = 0;
			}
			
		}
		
		public void display_arr(int[] arr) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+", ");
			}
			System.out.println();
		}
	
	}
	
class MST {
    
    
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        // Add your code here
        
        ArrayList<Edge> data = new ArrayList<>();
        
        for(int a=0; a<V; a++){
            for(int b=a; b<V; b++){
                if(graph.get(b).get(a)!=Integer.MAX_VALUE){
			        
			
			        data.add(new Edge(graph.get(b).get(a), a, b));
                }
            }
        }
        Collections.sort(data, new Compare());
        //System.out.println(data);
        
        DSU dsu = new DSU(V);
		
		int ans = 0;
		for(int i=0; i<E; i++) {
			int a = data.get(i).getA();
			int b = data.get(i).getB();
			int w = data.get(i).getWeight();
			
			if(dsu.get_superparent(a)!=dsu.get_superparent(b)) {
				//System.out.println(data.get(i));
				dsu.union(a, b);
				ans+=w;
			}
		}
		
        return ans;
        
    }
}
class Compare implements Comparator<Edge>{

	@Override
	public int compare(Edge e1, Edge e2) {
		// TODO Auto-generated method stub
		return e1.w-e2.w;
	}
	
}

public class Kruskal_GFG{
	
	public static void main(String[] args) {
		MST mst = new MST();
		//mst.spanningTree(V, E, graph); - Implemented by GFG
	}
}


