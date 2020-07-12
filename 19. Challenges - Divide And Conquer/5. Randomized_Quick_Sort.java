// Accepted on Coding Blocks

import java.util.*;
public class Randomized_Quick_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n; i++) {
			arr[i] = s.nextInt(); 
		}
		
		quick_sort(arr,0,n-1,n);
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}

	}
	
	static void display(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static void quick_sort(int[] arr,int i, int j, int n) {
		//System.out.println(i+" "+j);
		if (i>=j){
			return;
		}
		
		int p = partition(arr,i,j);
		//display(arr);
		quick_sort(arr, i, p-1, n);
		quick_sort(arr, p, j, n);
		
	}
	
	static int partition(int[] arr,int st, int end) {
		
		
		int r = (int)(Math.random()*(end-st+1)+st);
		System.out.println(st+", "+end+" "+r);
		swap(arr,r,end);
		
		int pivot = arr[end];
		int j = st-1;
		for(int i=st; i<end;i++) {
			if(arr[i]<=pivot) {
				j+=1;
				swap(arr,i,j);
			}
		}
		
		swap(arr,end,j+1);
		
		return j+1;
		
	}
	
	static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
