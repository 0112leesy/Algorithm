import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class DirectedGraph {
	// 인접리스트를 이용한 방향그래프 구현
	// 5 4
	// 1 2, 1 3, 2 4, 3 5

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//vertex의 개수
		int vCnt = Integer.parseInt(st.nextToken());
		//edge의 개수
		int eCnt = Integer.parseInt(st.nextToken());
		
		//List 인터페이스
		ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
		for(int i=0; i<=vCnt; i++) {
			adList.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<eCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adList.get(v1).add(v2);
		}
		
		//인접리스트 출력
		for(int i=1; i<=vCnt; i++) {
			Iterator<Integer> iter = adList.get(i).iterator();
			System.out.print("[" + i + "]: ");
			
			while(iter.hasNext()) {
				System.out.print(iter.next()+" ");
			}
			System.out.println();
		}
	}

}
