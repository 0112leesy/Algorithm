
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {0, 8, 4, 7, 1, 2, 6};
		System.out.print("���� �� �迭: ");
		for(int i : intArray) System.out.print(i+" ");
		System.out.println();
		
		heapSort(intArray);
		
		System.out.print("\n���� �� �迭: ");
		for(int i : intArray) System.out.print(i+" ");
		
	}
	
	static void heapSort(int[] arr) {
		int eh, temp;
		eh = arr.length - 1;
		
		// �־��� �迭�� ������ ����
		buildHeap(arr, eh);
		
		// ������ �ִ��� �����ϰ� ���� Ʈ���� �ٽ� ������ ����
		while(eh > 1) {
			// arr[1]�� arr[eh]�� ��ȯ
			temp = arr[1];
			arr[1] = arr[eh];
			arr[eh] = temp;
			
			System.out.print("temp:("+ temp + ") ");
			// ������ �ִ� ����
			eh = eh-1;
			
			// ���� Ʈ���� �ٽ� ������ ����
			pushDown(arr, 1, eh/2, eh);
			
			System.out.print("eh:("+ eh + ") ");
			for(int i=1; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}	
	
	// �迭 arr[1 ... eh]�� ������ ����
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
	
	// arr[x]�� �� ������ ������ ������ Ʈ���� �Ʒ� ������ ���� ����
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
	
	// arr[x]���� �� ū ���� ������ x�� �ڽ� ����� ������ ����
	static int findLarge(int[] arr, int x, int eh) {
		int ans = 0;
	
		if(2*x + 1 <= eh) {
			// �ڽ� ��尡 �� �� �ִ� ���
			if(arr[2*x] > arr[x] || arr[2*x+1] > arr[x]) {
				if(arr[2*x] >= arr[2*x+1]) ans = 2*x;
				else ans = 2*x+1;
			}
		}
		else {
			// �ڽ� ��尡 �ϳ��� �ִ� ���
			if(2*x <= eh && arr[2*x] > arr[x]) ans = 2*x;
		}
		
		return ans;
	}

}
