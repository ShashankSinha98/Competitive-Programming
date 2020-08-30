// https://www.hackerrank.com/challenges/journey-to-the-moon/problem

import java.util.*;
import java.io.*;

class GraphMoon{
	int V;
	ArrayList<ArrayList<Integer>> arr;
	
	public GraphMoon(int V) {
		this.V = V;
		this.arr = new ArrayList<>();
		for(int i=0; i<V; i++)
			arr.add(new ArrayList<>());
	}
	
	public void add_edge(int v1, int v2) {
		this.arr.get(v1).add(v2);
		this.arr.get(v2).add(v1);
	}
	
	public void display() {
		for(int i=0; i<this.V; i++) {
			System.out.print(i+"");
			ArrayList<Integer> list = this.arr.get(i);
			
			for(int j : list) {
				System.out.print(" -> "+j);
			}
			System.out.println();
		}
	}

	public void print_components() {
		int[] visited = new int[this.V];
		
		int cnt = 0;
		for(int i=0; i<this.V; i++) {
			if(visited[i]==0) {
				System.out.print("Component: "+(++cnt)+" --> ");
				traverse_dfs(i,visited);
				System.out.println();
			}
		}
	}
	
	public int nctwo(int n) {
		if(n==1)
			return 0;
		else 
			return ((n*(n-1))/2);
	}
	
	
	public ArrayList<Integer> get_components_sizes() {
		int[] visited = new int[this.V];
		
		ArrayList<Integer> sizes = new ArrayList<>();
		
		for(int i=0; i<this.V; i++) {
			//this.c = 0;
			if(visited[i]==0) {
				int res = traverse_dfs(i,visited);
				sizes.add(res);
			}
		}
		return sizes;
	}
	
	public int traverse_dfs(int st, int[] visited) {
		
		visited[st] = 1;
		ArrayList<Integer> list = this.arr.get(st);
		
		int res = 1;
		for(int i=0; i<list.size(); i++) {
			if(visited[list.get(i)]==0) {
				res += traverse_dfs(list.get(i), visited);
			}
		}
		return res;
	}
	
	public int solve(int n) {
		
		int total = nctwo(n);
		ArrayList<Integer> sizes = get_components_sizes();
		
		int same = 0;
		for(int i=0; i<sizes.size(); i++) {
			same += nctwo(sizes.get(i));
		}
		
		return total-same;
	}
}



public class Journey_to_the_Moon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int n = 5;
		int[][] astronaut = {{0,1},{2,3},{0,4}};
		
		GraphMoon g = new GraphMoon(n);
		for(int i=0; i<astronaut.length; i++) {
			int[] pair = astronaut[i];
			g.add_edge(pair[0], pair[1]);
		}
		
		System.out.println(g.solve(n));
		
		
	}

}
