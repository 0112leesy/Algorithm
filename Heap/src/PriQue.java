import java.util.Collections;
import java.util.PriorityQueue;

public class PriQue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		// 우선순위가 높은 숫자 순
		// PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		priorityQueue.add(3);     // priorityQueue 값 3 추가
		priorityQueue.add(4);     // priorityQueue 값 4 추가
		priorityQueue.add(1);     // priorityQueue 값 1 추가
		priorityQueue.add(10);    // priorityQueue 값 10 추가
		while(!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.poll());
		}		
	}

}
