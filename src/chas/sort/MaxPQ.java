package chas.sort;

public class MaxPQ<Key extends Comparable<Key>>{
	private Key[] pq;
	private int N = 0;
	
	public MaxPQ(int maxN){
		pq = (Key[]) new Comparable[maxN + 1];
	}
	
	public boolean isEmpty(){
	return N == 0;	
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Key v){
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax(){
		Key max = pq[1];
		Key tmp = pq[N];
		pq[N--] = pq[1];
		pq[1] = tmp;
		pq[N+1] = null;
		sink(1);
		return max;
		
	}
	public void swim(int k){
		while(k > 1 && pq[k/2].compareTo(pq[k]) < 0)
		{
			Key tmp = pq[k/2];
			pq[k/2] = pq[k];
			pq[k] = tmp;
			k = k / 2;
		}
		
		
	}
	
	public void sink(int k){
		
		while(2*k <= N){
			int j = k * 2;
			if(j < N && pq[j].compareTo(pq[j+1]) < 0)
				j += 1;
			if(pq[j].compareTo(pq[k]) > 0){
			Key tmp = pq[j];
			pq[j] = pq[k];
			pq[k] = tmp;
			k = j;
			}
			else
				break;
		}
	}
	public String toString(){
		String s = "";
		for(int i = 1; i <= N;i++)
			s =s + pq[i].toString() +" ";
		return s;
	}
	1
}
