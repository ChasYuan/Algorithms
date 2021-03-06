package chas.sort;

public class Example {
	
	public static void sort(Comparable[] a){};
	
	/* Compare */
	protected static boolean less(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}
	
	/* Exchange */
	protected static void exch(Comparable[] a,int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/* Display */
	protected static void show(Comparable[] a){
		for(int i = 0 ; i < a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
	}
	
	/* Check if it's sorted */
	public static boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
}
