import java.util.Collections;
import java.util.PriorityQueue;

public class PriQue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int�� priorityQueue ���� (�켱������ ���� ���� ��)
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		// �켱������ ���� ���� ��
		// PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		priorityQueue.add(3);     // priorityQueue �� 3 �߰�
		priorityQueue.add(4);     // priorityQueue �� 4 �߰�
		priorityQueue.add(1);     // priorityQueue �� 1 �߰�
		priorityQueue.add(10);    // priorityQueue �� 10 �߰�
		while(!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.poll());
		}		
	}

}
