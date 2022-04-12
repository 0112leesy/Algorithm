
public class MatrixChainMultiplication {
	
	// ���� ���� �����ϴ� �迭
	// ��� Mi�� row[i-1] * row[i] �����
	static int[] row;
	
	// M_from * ... * M_to�� ����ϱ� ���� �ּ� ���� Ƚ��
	static int MatrixMult_DC(int from, int to) { // ���� ����
		if(from == to) return 0;
		
		int min_val = Integer.MAX_VALUE;
		for(int i=from; i<to; i++) {
			min_val = Math.min(min_val, 
					MatrixMult_DC(from, i) + MatrixMult_DC(i+1, to) + row[from-1]*row[i]*row[to]);
		}
		return min_val;
	}
	
	// M_1 * ... M_x�� ����ϱ� ���� �ּ� ���� Ƚ��
	static int MatrixMult_DP(int n) { // ���� ��ȹ
		
		int ans[][] = new int[n][n];
		
		// ����� �ϳ��� ������ ���� �ʿ䰡 ����
		for(int i=1;i<n; i++) ans[i][i] = 0;
		
		// len�� ��� �������� ��, �� ����: 1���� ���ϳ�, 2���� ���ϳ�...
		for(int len = 1; len < n-1; len++) {
			for(int from = 1; from < n-len; from++) {
				int to = from + len;
				ans[from][to] = Integer.MAX_VALUE;
				
				for(int k = from; k < to; k++) {
					// q = �� ���� ��� ������ ������ �� ���ϴ� ����� �ּ� ���� Ƚ��
					int q = ans[from][k] + ans[k+1][to] + row[from-1] * row[k] * row[to];
					if(q < ans[from][to]) ans[from][to] = q;
				}
			}
		}
		return ans[1][n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		row = new int[] {10, 20, 50, 1, 100};
		int size = row.length;
		
		System.out.println("���� ������ �̿��� �ּ� ���� Ƚ��: " + MatrixMult_DC(1, size-1));
		System.out.println("���� ��ȹ�� �̿��� �ּ� ���� Ƚ��: " + MatrixMult_DP(size));
	}

}
