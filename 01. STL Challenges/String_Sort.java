import java.util.*;
public class String_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		
		ArrayList<String> arr = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			arr.add(s.next());
		}
		
		Collections.sort(arr, new CustomSort());
				
		for(String str:arr) {
			System.out.print(str+"	");
		}
	}

}

class CustomSort implements Comparator<String>{
	
	public int compare(String b,String a) {
		
		if(a.length() <= b.length() && b.substring(0,a.length()).equals(a)) {
			return -1;
		}else if(b.length() <= a.length() && a.substring(0,b.length()).equals(b))
			return 1;
		else 
			return b.compareTo(a);	
	}
}
