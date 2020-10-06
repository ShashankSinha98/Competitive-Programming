import java.util.*;

class TrieNode{
	TrieNode left,right;
}

class Trie{
	TrieNode head;
	
	Trie(){
		head = new TrieNode();
	}
	
	public void addData(int n) {
		TrieNode curr = this.head;
		
		for(int i=31;i>=0;i--) {
			int curr_bit = (n>>i) & 1;
			
			if(curr_bit==0) {
				if(curr.left==null)
					curr.left = new TrieNode();
				curr = curr.left;
			} else {
				if(curr.right==null)
					curr.right = new TrieNode();
				curr = curr.right;
			}
		}
	}
	
	public int maxXorProfit(int n) {
		int curr_xor = 0;
		TrieNode curr = this.head;
		
		for(int i=31;i>=0;i--) {
			int curr_bit = (n>>i) & 1;
			
			if(curr_bit==0) {
				if(curr.right != null) {
					curr = curr.right;
					curr_xor += (int)(Math.pow(2, i));
				} else 
					curr = curr.left;
			} else {
				if(curr.left != null) {
					curr = curr.left;
					curr_xor += (int)(Math.pow(2, i));
				} else 
					curr = curr.right;
			}
		}
		
		return curr_xor;
	}
}



public class Max_Xor_Pair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {14,70,53,83,49,91,36,80,92,51,66,70};
		
		Trie trie = new Trie();
		int ans = 0;
		for(int i=0; i<arr.length; i++) {
			trie.addData(arr[i]);
			int x = trie.maxXorProfit(arr[i]);
			
			ans = Math.max(x, ans);
		}
		
		System.out.println("Ans: "+ans);

	}

}
