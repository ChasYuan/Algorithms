package chas.sort;

public class Merge extends Example{
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a,0,a.length - 1);
		
		/* 
		 * int N = a.length;
		 * aux = new Comparable[N];
		 * for(int sz = 1;sz < N;sz = sz+sz){
		 * 	for(int lo = 0; lo < N - sz; lo += (sz+sz))
		 * 		merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
		 * }
		 * */
	}
	
	private static void sort(Comparable[] a,int lo, int hi){
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	public static void merge(Comparable[] a,int lo, int mid, int hi){
		int i = lo;
		int j = mid + 1;
		
		for(int k = lo; k <= hi; k++)
			aux[k] = a[k];
			
		for(int k = lo; k <= hi; k++){
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[j],aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}
	
//	public static void main(String[] args){
//		Integer[] a = {56,23,5,3,7,455,78,2,45,782,45,8,34,6,82,557,23,6,783};
//		Merge.sort(a);
//		Merge.show(a);
//	}
	
}
