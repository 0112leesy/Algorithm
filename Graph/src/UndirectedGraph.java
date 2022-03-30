import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UndirectedGraph {
	// 인접행렬을 이용한 무방향 그래프 구현
	// 6 8
	// 1 2, 1 3, 2 3, 2 4, 3 4, 3 5, 4 5, 4 6

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// vertex와 edge의 개수
		int vCnt = Integer.parseInt(st.nextToken());
		int eCnt = Integer.parseInt(st.nextToken());
		
		// 인접 행렬 생성
		int[][] adMatrix = new int[vCnt+1][vCnt+1];
		
		for(int i=0; i<eCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adMatrix[v1][v2] = 1;
			adMatrix[v2][v1] = 1;
		}
		
		// 인접 행렬 출력
		for(int i=1; i<=vCnt; i++) {
			for(int j=1; j<=vCnt; j++) {
				System.out.print(adMatrix[j][i] + " ");
			}
			System.out.println();
		}
		
	}

}
