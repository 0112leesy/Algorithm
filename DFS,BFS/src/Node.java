import java.util.ArrayList;
import java.util.List;

public class Node {
	
	int info;
	boolean visited;
	List<Node> neighbors;
	
	public Node(int info) {
		this.info = info;
		visited = false;
		neighbors = new ArrayList<>();
	}
	
	public void addNeighbors(Node neighborsNode) {
		neighbors.add(neighborsNode);
	}
	
	public List<Node> getNeighbors(){
		return neighbors;
	}
	
	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}
	
	public String toString() {
		return "" + info;
	}
}
