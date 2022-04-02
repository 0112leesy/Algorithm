
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {0, 8, 4, 7, 1, 2, 6};
		System.out.print("정렬 전 배열: ");
		for(int i : intArray) System.out.print(i+" ");
		System.out.println();
		
		heapSort(intArray);
		
		System.out.print("\n정렬 후 배열: ");
		for(int i : intArray) System.out.print(i+" ");
		
	}
	
	static void heapSort(int[] arr) {
		int eh, temp;
		eh = arr.length - 1;
		
		// 주어진 배열을 힙으로 만듬
		buildHeap(arr, eh);
		
		// 힙에서 최댓값을 제거하고 남은 트리를 다시 힙으로 만듬
		while(eh > 1) {
			// arr[1]과 arr[eh]를 교환
			temp = arr[1];
			arr[1] = arr[eh];
			arr[eh] = temp;
			
			System.out.print("temp:("+ temp + ") ");
			// 힙에서 최댓값 제거
			eh = eh-1;
			
			// 남은 트리를 다시 힙으로 만듬
			pushDown(arr, 1, eh/2, eh);
			
			System.out.print("eh:("+ eh + ") ");
			for(int i=1; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}	
	
	// 배열 arr[1 ... eh]를 힙으로 만듬
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
	
	// arr[x]를 힙 조건이 만족될 때까지 트리의 아래 층으로 내려 보냄
	static void pushDown(int[] arr, int x, int bh, int eh) {
		int y, temp;
		y = findLarge(arr, x, eh);
		
		while(arr[x] < arr[y]) {
			temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
			x = y;
			y = findLarge(arr, x, eh);
		}
		
	}
	
	// arr[x]보다 더 큰 값을 가지는 x의 자식 노드의 지수를 구함
	static int findLarge(int[] arr, int x, int eh) {
		int ans = 0;
	
		if(2*x + 1 <= eh) {
			// 자식 노드가 둘 다 있는 경우
			if(arr[2*x] > arr[x] || arr[2*x+1] > arr[x]) {
				if(arr[2*x] >= arr[2*x+1]) ans = 2*x;
				else ans = 2*x+1;
			}
		}
		else {
			// 자식 노드가 하나만 있는 경우
			if(2*x <= eh && arr[2*x] > arr[x]) ans = 2*x;
		}
		
		return ans;
	}

}
