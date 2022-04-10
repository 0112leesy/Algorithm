import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	
	static Queue<Node> queue = new LinkedList<Node>();
	
	static void bfs(Node v) {
		v.visited = true;
		queue.add(v);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.info + " ");
			
			for(Node n : temp.getNeighbors()) {
				if(!n.visited) {
					n.visited = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.addNeighbors(node2);
		node1.addNeighbors(node3);
		node1.addNeighbors(node5);
		node2.addNeighbors(node1);
		node2.addNeighbors(node3);
		node3.addNeighbors(node1);
		node3.addNeighbors(node2);
		node3.addNeighbors(node4);
		node3.addNeighbors(node5);
		node4.addNeighbors(node3);
		node4.addNeighbors(node6);
		node5.addNeighbors(node1);
		node5.addNeighbors(node3);		
		node6.addNeighbors(node3);
		node6.addNeighbors(node4);
		
		// �־��� ������ �׷����� �ʺ� �켱 Ž������ ��ȸ��
		System.out.println("�ʺ� �켱 Ž�� ���� ��� =");
		bfs(node1);
	}
}
