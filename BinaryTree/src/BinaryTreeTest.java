
public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		
		int[] input = {8,7,1,9,3,2,6,4,5};
		
		// ��� ����
		for(int n : input) tree.insert(n);
		
		// ���� �� ���
		tree.display(tree.root);
		
		tree.deleteBT(1);
		tree.deleteBT(3);
		
		tree.display(tree.root);
		
		
	}

}
