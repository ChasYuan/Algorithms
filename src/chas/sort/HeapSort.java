package chas.sort;
/* a[0] is null */
public class HeapSort extends Example{
	
	public static void sort(Comparable[] a){
		int N = a.length - 1;
		for(int k = N/2; k >= 1;k--)
			sink(a,k,N);
		while(N > 1){
			exch(a,1,N--);
			sink(a,1,N);
		}
		
	}
	
	private static void sink(Comparable[] a,int k, int N){
		while(2*k <= N){
			int j = k * 2;
			if(j < N && a[j].compareTo(a[j+1]) < 0)
				j += 1;
			if(a[j].compareTo(a[k]) > 0){
			exch(a,j,k);
			k = j;
			}
			else
				break;
		}
	}
	
	private static void swim(Comparable[] a,int k,int N){
		while(k > 1 && a[k/2].compareTo(a[k]) < 0)
		{
			exch(a,k,k/2);
			k = k / 2;
		}
	}
	
	public static void show(Comparable[] a){
		for(int i = 1; i < a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
	}
//	public static void main(String[] args){
//		String[] s = {"null","A","K","S","E","O","i","T","x","e"};
//		HeapSort.sort(s);		
//		HeapSort.show(s);
//	}
}
