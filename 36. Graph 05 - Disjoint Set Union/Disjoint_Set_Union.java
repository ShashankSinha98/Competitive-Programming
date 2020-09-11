import java.util.*;
public class Disjoint_Set_Union {
	
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
				this.size[superparent_x] = 0;
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
		
		Scanner s = new Scanner(System.in);
		
		String[] arr = s.nextLine().split("\\s+");
		int N = Integer.valueOf(arr[0]);
		int M = Integer.valueOf(arr[1]);
		
		DSU g = new Disjoint_Set_Union().new DSU(N);
		
		for(int i=0; i<M; i++) {
			arr = s.nextLine().split("\\s+");
			int x = Integer.valueOf(arr[0]);
			int y = Integer.valueOf(arr[1]);
			g.union(x, y);
		}
		
		int ans = 0;
		for(int i=0;i<N; i++) {
			int superparent_i = g.get_superparent(i);
			ans+=(N-g.size[superparent_i]);
		}
		//g.display_arr(g.size);
		System.out.println(ans/2);

	}

}
