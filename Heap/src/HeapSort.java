
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {0, 8, 4, 7, 1, 2, 6};
		System.out.print("정렬 전 배열: ");
		for(int i : intArray) System.out.print(i+" ");
		
		heapSort(intArray);
		
		System.out.print("\n정렬 후 배열: ");
		for(int i : intArray) System.out.print(i+" ");
		
	}
	
	static void heapSort(int[] arr) {
		int eh, temp;
		eh = arr.length - 1;
		
		// 주어진 배열을 힙으로 만듬
		buildHeap(arr, eh);
	}
	
	static void buildHeap(int[] arr, int eh) {
		int bh, x;
		bh = (arr.length-1)/2 + 1;
		
		while(bh > 1) {
			bh = bh-1;
			x = bh;
			// x에서 힙 조건이 만족될 때까지 arr[x]를 트리의 아래층으로 내려 보냄
			pushDown(arr, x, bh, eh);
		}
	}
	
	static void pushDown(int[] arr, int x, int bh, int eh) {
		
	}

}
