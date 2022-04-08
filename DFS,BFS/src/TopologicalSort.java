import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	
	static Stack<Node> stack = new Stack<>();
	
	static void topologicalSort(Node v) {
		// 정점 v에 인접한 정점들의 연결 목록을 끄집어 냄
		List<Node> neighbors = v.getNeighbors();
		
		// v에 인접한 모든 정점에 대해 DFS를 함
		for(int i=0; i<neighbors.size(); i++) {
			Node w = neighbors.get(i);
			
			if(w != null && !w.visited) {
				w.visited = true;
				topologicalSort(w);
			}
		}
		
		// v를 스택에 밀어 넣음
		stack.push(v);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		node0.addNeighbors(node1);
		node0.addNeighbors(node3);
		
		node1.addNeighbors(node2);
		node1.addNeighbors(node4);
		node2.addNeighbors(node4);
		node2.addNeighbors(node6);
		node3.addNeighbors(node4);
		node3.addNeighbors(node5);
		node4.addNeighbors(node6);
		node5.addNeighbors(node6);
		node5.addNeighbors(node7);
		node6.addNeighbors(node7);
		
		System.out.println("위상 정렬 순서:");
		node0.visited = true;
		topologicalSort(node0);
		while(!stack.empty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}
