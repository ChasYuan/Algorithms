package chas.sort;

public class Quick extends Example{
	public static void sort(Comparable[] a){
		sort(a,0,a.length - 1);
	}
	
	private static void sort(Comparable[] a,int lo, int hi){
		if(hi <= lo) return;
		
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	private static int partition(Comparable[] a,int lo, int hi){
		int i = lo,j = hi + 1;
		Comparable v = a[lo];
		while(true){
			while(less(a[++i],v)) if(i == hi)break;
			while(less(v,a[--j])) if(j == lo)break;
			if(i >= j)break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
//	public static void main(String[] args){
//		Integer[] a = {56,23,5,3,7,455,78,2,45,782,45,8,34,6,82,557,23,6,783};
//		Quick.sort(a);
//		Quick.show(a);
//	}
}
