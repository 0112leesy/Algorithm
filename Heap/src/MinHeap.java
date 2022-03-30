import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinHeap {
	
	public static class minHeap{
		private ArrayList<Integer> heap;
		
		// 힙 생성자
		public minHeap() {
			heap = new ArrayList<>();
			heap.add(0);
		}
		
		// 삽입
		public void insert(int val) {
			heap.add(val);
			int p = heap.size()-1;
			
			while(p>1 && heap.get(p/2)>heap.get(p)) {
				System.out.println("swap"); // 변경 필요
				int temp = heap.get(p/2);
				heap.set(p/2, heap.get(p));
				heap.set(p, temp);
				p = p/2; // 부모 노드 인덱스에서 다시 탐색
			}
		}
		
		// 삭제
		public int delete() {
			if(heap.size()-1 < 1) {
				return 0;
			}
			
			int deleteItem = heap.get(1);
			
			heap.set(1, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			
			int pos = 1;
			while((pos*2) < heap.size()) {
				int min = heap.get(pos*2);
				int minPos = pos*2;
				
				if(((pos*2+1)<heap.size()) && min>heap.get(pos*2+1)) {
					min = heap.get(pos*2+1);
					minPos = pos*2+1;
				}
				if(heap.get(pos)<min) break;
				
				// 부모 자식 노드 교환
				int temp = heap.get(pos);
				heap.set(pos, heap.get(minPos));
				heap.set(minPos, temp);
				pos = minPos;
			}
		return deleteItem;
		}
		
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		minHeap heap = new minHeap();
		for(int i=0; i<N; i++) {
			int val = Integer.parseInt(br.readLine());
			if(val == 0) System.out.println(heap.delete());
			else heap.insert(val);
		}
	}

}
