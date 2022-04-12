
public class MatrixChainMultiplication {
	
	// 행의 수를 저장하는 배열
	// 행렬 Mi는 row[i-1] * row[i] 행렬임
	static int[] row;
	
	// M_from * ... * M_to를 계산하기 위한 최소 곱셈 횟수
	static int MatrixMult_DC(int from, int to) { // 분할 정복
		if(from == to) return 0;
		
		int min_val = Integer.MAX_VALUE;
		for(int i=from; i<to; i++) {
			min_val = Math.min(min_val, 
					MatrixMult_DC(from, i) + MatrixMult_DC(i+1, to) + row[from-1]*row[i]*row[to]);
		}
		return min_val;
	}
	
	// M_1 * ... M_x를 계산하기 위한 최소 곱셈 횟수
	static int MatrixMult_DP(int n) { // 동적 계획
		
		int ans[][] = new int[n][n];
		
		// 행렬이 하나만 있으면 곱할 필요가 없음
		for(int i=1;i<n; i++) ans[i][i] = 0;
		
		// len은 행렬 곱셈들의 수, 즉 간격: 1개를 곱하냐, 2개를 곱하냐...
		for(int len = 1; len < n-1; len++) {
			for(int from = 1; from < n-len; from++) {
				int to = from + len;
				ans[from][to] = Integer.MAX_VALUE;
				
				for(int k = from; k < to; k++) {
					// q = 두 개의 행렬 곱으로 분할한 후 곱하는 경우의 최소 곱셈 횟수
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
		
		System.out.println("분할 정복을 이용한 최소 곱셈 횟수: " + MatrixMult_DC(1, size-1));
		System.out.println("동적 계획을 이용한 최소 곱셈 횟수: " + MatrixMult_DP(size));
	}

}
