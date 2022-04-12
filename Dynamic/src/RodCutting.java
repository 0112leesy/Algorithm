
public class RodCutting {
	
	// ���� ���̺� ����
	static int price[];
	
	// ���� x�� ������ �ִ� �Ǹ� ����
	static int cutRod_DC(int x) { // ���� ����
		
		if(x == 0) return 0;
		
		int maxSell = 0;
		for(int i=1; i<=x; i++) {
			maxSell = Math.max(maxSell, price[i-1] + cutRod_DC(x-i));
		}
		return maxSell;
	}
	
	static int cutRod_DP(int x) { // ���� ��ȹ
		
		int maxSell[] = new int[x+1];
		maxSell[0] = 0;
		
		for(int i=1; i<=x; i++) {
			int max_val = 0;
			for(int j=1; j<=i; j++) {
				max_val = Math.max(max_val, price[j-1] + maxSell[i-j]);
			}
			maxSell[i] = max_val;
		}
		return maxSell[x];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		price = new int[] {2, 5, 9, 10};
		int size = price.length;
		
		System.out.println("���� ������ �̿��Ͽ� ���� �ִ� �Ǹ� �ݾ�: " + cutRod_DC(size));
		System.out.println("���� ��ȹ�� �̿��Ͽ� ���� �ִ� �Ǹ� �ݾ�: " + cutRod_DP(size));
		
	}

}
