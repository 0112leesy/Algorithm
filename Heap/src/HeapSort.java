
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {0, 8, 4, 7, 1, 2, 6};
		System.out.print("���� �� �迭: ");
		for(int i : intArray) System.out.print(i+" ");
		
		heapSort(intArray);
		
		System.out.print("\n���� �� �迭: ");
		for(int i : intArray) System.out.print(i+" ");
		
	}
	
	static void heapSort(int[] arr) {
		int eh, temp;
		eh = arr.length - 1;
		
		// �־��� �迭�� ������ ����
		buildHeap(arr, eh);
	}
	
	static void buildHeap(int[] arr, int eh) {
		int bh, x;
		bh = (arr.length-1)/2 + 1;
		
		while(bh > 1) {
			bh = bh-1;
			x = bh;
			// x���� �� ������ ������ ������ arr[x]�� Ʈ���� �Ʒ������� ���� ����
			pushDown(arr, x, bh, eh);
		}
	}
	
	static void pushDown(int[] arr, int x, int bh, int eh) {
		
	}

}
