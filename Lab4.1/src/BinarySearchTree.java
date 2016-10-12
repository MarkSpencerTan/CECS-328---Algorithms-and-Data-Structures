
public class BinarySearchTree {
	class Node{
		private Comparable value;
		private Node leftChild, rightChild, parent;
	}
	private Node root;
	
	public BinarySearchTree(){
		root = new Node();
		root.value = 5;
		Node lchild = new Node();
		lchild.value = 4;
		root.leftChild = lchild;
		Node rchild = new Node();
		rchild.value = 7;
		root.rightChild = rchild;
		Node lgrandchild = new Node();
		lgrandchild.value = 2;
		lchild.leftChild = lgrandchild;
		Node rgrandchild1 = new Node();
		rgrandchild1.value = 6;
		rchild.leftChild = rgrandchild1;
		Node rgrandchild2 = new Node();
		rgrandchild2.value = 9;
		rchild.rightChild = rgrandchild2;
	}
	
	//prints out root node and its children with in-order traversal
	public void printInOrder(){
		printInOrder(root);
	}
	
	public void printInOrder(Node n){
		if(n == null){
			return;
		}
		printInOrder(n.leftChild);
		System.out.println(n.value);
		printInOrder(n.rightChild);
	}
	
	public static void main(String[] args) {
		BinarySearchTree btree = new BinarySearchTree();
		btree.printInOrder();
	}
}
