package chas.search;


public class RedBlackBST<Key extends Comparable<Key>,Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;
	
	private class Node{
		Key key;
		Value val;
		Node left,right;
		int N;
		boolean color;
		
		Node(Key key, Value val, int N , boolean color){
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
		
		private boolean isRed(Node x){
			if(x == null) return false;
			return x.color == RED;
		}
	}
	
	private Node rorateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private Node rorateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node x){
		if(x == null) return 0;
		return x.N;
	}
	
	public Key select(int k){
		return select(root,k).key;
	}
	
	private Node select(Node x, int k){
		if(x == null) return null;
		int t = size(x.left);
		if(t > k) return select(x.left, k);
		else if(t < k) return select(x.right, k-t-1);
		else return x;
	}
	
	public int rank(Key key){
		return rank(root, key);
	}
	
	private int rank(Node x, Key key){
		if(x == null)return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(x.left, key);
		else if(cmp > 0) return rank(x.right, key) + size(x.left) + 1;
		else return size(x.left);
		
	}
	
	public Key min(){
		return min(root).key;
	}
	
	private Node min(Node x){
		if(x.left == null) return x;
		return min(x.left);
	}
	
	public Key max(){
		return max(root).key;
	}
	
	private Node max(Node x){
		if(x.right == null)return x;
		return max(x.right);
	}
	
	
	public Key floor(Key key){
		Node x = floor(root,key);
		if(x == null) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t != null) return t;
		else return x;
	}
	
	public Key ceiling(Key key){
		Node x = ceiling(root,key);
		if(x == null) return null;
		return x.key;
	}
	
	private Node ceiling(Node x, Key key){
		if(x == null ) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp > 0) return ceiling(x.right, key);
		Node t = ceiling(x.left,key);
		if(t != null) return t;
		else return x;
	}
}
