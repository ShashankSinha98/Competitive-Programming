import java.util.*;

class Edge{
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

public class Min_Spanning_Tree_Kruskal_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String[] arr = s.nextLine().split("\\s+");
		int N = Integer.valueOf(arr[0]);
		int M = Integer.valueOf(arr[1]);
		
		ArrayList<Edge> data = new ArrayList<>();
		for(int i=0; i<M; i++) {
			arr = s.nextLine().split("\\s+");
			int a = Integer.valueOf(arr[0]);
			int b = Integer.valueOf(arr[1]);
			int w = Integer.valueOf(arr[2]);
			
			data.add(new Edge(w, --a, --b));
		}
		
		Collections.sort(data, new Compare());
		
		System.out.println(data);


		/*
I/P-
9 15
1 2 10
2 3 9
1 3 12
3 5 3
5 4 7
2 4 8
3 6 1
4 6 10
5 6 3
7 4 8
7 8 9
7 9 2
8 6 6
4 8 5
9 8 11

O/P- 43
		*/
		
		Disjoint_Set_Union.DSU dsu = new Disjoint_Set_Union().new DSU(N);
		
		int ans = 0;
		for(int i=0; i<M; i++) {
			int a = data.get(i).getA();
			int b = data.get(i).getB();
			int w = data.get(i).getWeight();
			
			if(dsu.get_superparent(a)!=dsu.get_superparent(b)) {
				System.out.println(data.get(i));
				dsu.union(a, b);
				ans+=w;
			}
		}
		
		System.out.println(ans);
		
	}
	

}

class Compare implements Comparator<Edge>{

	@Override
	public int compare(Edge e1, Edge e2) {
		// TODO Auto-generated method stub
		return e1.w-e2.w;
	}
	
}

