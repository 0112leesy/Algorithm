import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepthFirstSearch {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nV = Integer.parseInt(br.readLine()); // ������ ����
		// int nE = Integer.parseInt(br.readLine()); // ������ ���� -> ���� �Է½� ���
		
		// nV:8,	nE:10
		DfsGraph dfsGraph = new DfsGraph(nV);
		dfsGraph.put(1, 2);
        dfsGraph.put(1, 3);
        dfsGraph.put(2, 4);
        dfsGraph.put(2, 5);
        dfsGraph.put(3, 6);
        dfsGraph.put(3, 7);
        dfsGraph.put(4, 8);
        dfsGraph.put(5, 8);
        dfsGraph.put(6, 8);
        dfsGraph.put(7, 8);

        // ������� ���
        dfsGraph.printGraphtoAdjArr();
        
        // ���� ������� �׷��� Ž��
        for(int i=1; i<=nV; i++) {
        	System.out.println();
        	System.out.println("���� "+ i + "���� Ž�� :");
        	dfsGraph.clearVisitArr();
        	dfsGraph.dfs(i);
        }
	}

}
