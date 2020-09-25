import java.util.*;
class Activity{
	int st;
	int end;
	
	Activity(int st, int end){
		this.st = st;
		this.end = end;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.st+","+this.end+")";
	}
}

public class Activity_Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t--!=0) {
			int n = s.nextInt();
			ArrayList<Activity> list = new ArrayList<>();
			s.nextLine();
			for(int i=0; i<n; i++) {
				String[] strarr = s.nextLine().split("\\s+");
				int st = Integer.valueOf(strarr[0]);
				int end = Integer.valueOf(strarr[1]);
				
				list.add(new Activity(st, end));
			}
			
			Collections.sort(list, new EndSort());
			
			//System.out.println(list);
			int cnt = 1;
			Activity last = list.get(0);
			for(int i=1;i<list.size(); i++) {
				if(list.get(i).st>=last.end) {
					last = list.get(i);
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}

class EndSort implements Comparator<Activity>{
	
	public int compare(Activity a1, Activity a2) {
		if(a1.end>=a2.end)
			return 1;
		else
			return -1;
	}
}
