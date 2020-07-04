import java.util.*;
public class Codes_of_the_String {
	
	static String[] map = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u"
	             ,"v","w","x","y","z"};
	
	static ArrayList<String> res = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		
		solve(str,0,"");
		
		String output = "[";
		
		for(int i=0;i<res.size(); i++) {
			if (i != res.size()-1) {
				output+=res.get(i)+", ";
			} else {
				output+=res.get(i)+"]";
			}
		}
		
		System.out.println(output);

	}
	
	static void solve(String str,int i,String out) {
		if (i==str.length()) {
			res.add(out);
			//System.out.print(out+" ");
			return;
		}
		 solve(str, i+1, out+map[str.charAt(i)-'0']);
		 if (str.substring(i).length()>=2 && Integer.valueOf(str.substring(i,i+2)) <=26)
			 solve(str, i+2, out+map[Integer.valueOf(str.substring(i,i+2))]);
		
	}

}
