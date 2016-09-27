package chas.sort;

public class Quick3way extends Quick{
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo) return;
		int lt = lo,i = lo + 1,gt = hi;
		Comparable v = a[lo];
		while(i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0) exch(a,lt++,i++);
			else if(cmp > 0)exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
//	public static void main(String[] args){
//		Integer[] a = {56,23,5,3,7,455,78,2,45,782,45,8,34,6,82,557,23,6,783};
//		Quick3way.sort(a);
//		Quick3way.show(a);
//	}
}
