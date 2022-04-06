import java.util.Arrays;

public class DfsGraph {
	// 인접행렬을 이용한 DFS 구현
	
	private int nV; // 정점의 개수
	private int[][] dfsGraph; // 인접행렬
	private boolean[] visitArr; // 정점 방문 여부
	
	DfsGraph(int nV){
		this.nV = nV;
		dfsGraph = new int[this.nV+1][this.nV+1];
		visitArr = new boolean[this.nV+1];
	}
	
	public int[][] getGraph() {
		return dfsGraph;
	}
	
	public void put(int x, int y) { // 양방향 간선 추가
		dfsGraph[x][y] = dfsGraph[y][x] = 1;
	}
	
	public void putSingle(int x, int y) { // 단방향 간선 추가
		dfsGraph[x][y] = 1;
	}
	
	public void printGraphtoAdjArr() { // 인접행렬 출력
		for(int i=1; i<=nV; i++) {
			for(int j=1; j<=nV; j++) {
				System.out.print(" " + dfsGraph[i][j]);
			}
			System.out.println();
		}
	}
	
	public void clearVisitArr() {
		Arrays.fill(visitArr, false);
	}
	
	public void dfs(int x) {
		visitArr[x] = true;
		System.out.print(x+" ");
		
		for(int i=1; i<=nV; i++) {
			if(dfsGraph[x][i] == 1 && !visitArr[i]) dfs(i);
		}
	}
}
