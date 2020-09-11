import java.util.*;
public class Cycle_Detection_DSU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String[] arr = s.nextLine().split("\\s+");
		int N = Integer.valueOf(arr[0]);
		int M = Integer.valueOf(arr[1]);
		
		Disjoint_Set_Union.DSU dsu = new Disjoint_Set_Union().new DSU(N);
		
		for(int i=0; i<M; i++) {
			arr = s.nextLine().split("\\s+");
			int x = Integer.valueOf(arr[0]);
			int y = Integer.valueOf(arr[1]);
				
			if(dsu.get_superparent(x)!=dsu.get_superparent(y)) {
				dsu.union(x, y);
			} else {
				System.out.println("Cycle exists!");
				System.exit(0);
			}
		}
		
		System.out.println("Cycle Doesn't exist");
		s.close();
		
		
	}

}
