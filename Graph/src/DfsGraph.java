import java.util.Arrays;

public class DfsGraph {
	// ��������� �̿��� DFS ����
	
	private int nV; // ������ ����
	private int[][] dfsGraph; // �������
	private boolean[] visitArr; // ���� �湮 ����
	
	DfsGraph(int nV){
		this.nV = nV;
		dfsGraph = new int[this.nV+1][this.nV+1];
		visitArr = new boolean[this.nV+1];
	}
	
	public int[][] getGraph() {
		return dfsGraph;
	}
	
	public void put(int x, int y) { // ����� ���� �߰�
		dfsGraph[x][y] = dfsGraph[y][x] = 1;
	}
	
	public void putSingle(int x, int y) { // �ܹ��� ���� �߰�
		dfsGraph[x][y] = 1;
	}
	
	public void printGraphtoAdjArr() { // ������� ���
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
