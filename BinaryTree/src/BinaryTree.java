
public class BinaryTree {
	public Node root;
	
	BinaryTree(){
		root = null;
	}
	
	// ����Ʈ�� Ž�� ����
	public boolean find(int key) {
		Node currentNode = root;
		while(currentNode != null) {
			if(currentNode.getData() == key) {
				return true;
			}
			else if(currentNode.getData() > key) {
				currentNode = currentNode.getLeft();
			}
			else {
				currentNode = currentNode.getRight();
			}
		}
		return false;
	}
	
	// ����Ʈ�� ��� ����
	public void display(Node root) {
		if(root != null) {
			display(root.getLeft());
			System.out.println(" "+ root.getData());
			display(root.getRight());
		}
	}
	
	// ����Ʈ�� ���� ����
	public boolean insert(int value) {
		Node newNode = new Node(value);
		if(find(value)) {
			return false;
		}
		if(root == null) {
			root = newNode;
			return true;
		}
		Node currentNode = root;
		Node parent;
		while(true) {
			parent = currentNode;
			if(value < currentNode.getData()) {
				currentNode = currentNode.getLeft();
				if(currentNode == null) {
					parent.setLeft(newNode);
					return true;
				}
			}
			else {
				currentNode = currentNode.getRight();
				if(currentNode == null) {
					parent.setRight(newNode);
					return true;
				}
			}
		}
	}
	
	// Ư�� ��� ���� ����
	public boolean deleteBT(int id) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.getData() != id) {
			parent = current;
			if(current.getData() > id) {
				isLeftChild = true;
				current = current.getLeft();
			}
			else {
				isLeftChild = false;
				current = current.getRight();
			}
			if(current == null) {
				return false;
			}
		}
		
		// case 1: �ڽ� ��尡 ���� ���
		if(current.getLeft()==null && current.getRight()==null) {
			if(current == root) {
				root = null;
			}
			if(isLeftChild) {
				parent.setLeft(null);
			}
			else {
				parent.setRight(null);
			}
		}
		
		// case 2: �ڽ� ��尡 1���� ���
		else if(current.getRight()==null) { // ���ʿ� �ϳ��� �ڽ��� ����
			if(current == root) {
				root = current.getLeft();
			}
			else if(isLeftChild) {
				parent.setLeft(current.getLeft());
			}
			else {
				parent.setRight(current.getLeft());
			}
		}
		else if(current.getLeft()==null) { // �����ʿ� �ϳ��� �ڽ��� ����
			if(current == root) {
				root = current.getRight();
			}
			else if(isLeftChild) {
				parent.setLeft(current.getRight());
			}
			else {
				parent.setRight(current.getRight());
			}
		}
		
		// case 3: �ڽ� ��尡 2���� ���
		else if(current.getLeft()!=null && current.getRight()!=null) {
			// ������ ����� ����Ʈ���� �� (a) Ȥ�� (b)�� ã��
			Node successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			}
			else if(isLeftChild) {
				parent.setLeft(successor);
			}
			else {
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
		}
		
		return true;
	}
	
	public Node getSuccessor(Node deleteNode) {
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.getRight();
		// (a) ������ ����Ʈ���� �ּڰ��� ã��
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if(successor != deleteNode.getRight()) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(deleteNode.getRight());
		}
		return successor;
		
		/* (b) ���� ����Ʈ���� �ִ��� ã��
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.getRight();
		}
		if(successor != deleteNode.getLeft()) {
			successorParent.setRight(successor.getLeft());
			successor.setLeft(deleteNode.getLeft());
		}
		 */
	}
}
