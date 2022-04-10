
public class DepthFirstSearch {
	
	static void dfs(Node v) {
		v.visited = true;
		System.out.print(v.info + " ");
		
		for(Node w : v.getNeighbors()) {
			if(!w.visited) {
				dfs(w);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node[] node = new Node[6];
		
		for(int i=0; i<6; i++) {
			node[i] = new Node(i+1);
			System.out.println(node[i]);
		}
		
		node[0].addNeighbors(node[1]);
		node[0].addNeighbors(node[2]);
		node[0].addNeighbors(node[4]);
		node[1].addNeighbors(node[0]);
		node[1].addNeighbors(node[2]);
		node[2].addNeighbors(node[0]);
		node[2].addNeighbors(node[1]);
		node[2].addNeighbors(node[3]);
		node[2].addNeighbors(node[4]);
		node[3].addNeighbors(node[2]);
		node[3].addNeighbors(node[5]);
		node[4].addNeighbors(node[0]);
		node[4].addNeighbors(node[2]);
		node[5].addNeighbors(node[2]);
		node[5].addNeighbors(node[3]);
		
		// �־��� ������ �׷����� ���� �켱 Ž������ ��ȸ��
		System.out.println("��͸� ����� ���� �켱 Ž�� ���� ���");
		dfs(node[0]);
	}

}
