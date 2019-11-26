package kr.ac.sunmoon;

public class LCSAlgorithm {
	public static int createMatrix(int[][] c, String[] X, String[] Y) {
		for(int i=1; i<X.length+1; i++) {
			for(int j=1; j<Y.length+1; j++) {
				if(X[i-1].equals(Y[j-1]))
					c[i][j] = c[i-1][j-1] + 1;
				else
					c[i][j] = Math.max(c[i][j-1], c[i-1][j]);
			}
		}
		return c[X.length][Y.length];
	}
	public static void main(String[] args) {
		final String[] X = {"음악", "음식", "여행", "야구", "만화"};
		final String[] Y = {"여행", "야구", "음악", "음식", "독서"};
		final int[][] c = new int[X.length+1][Y.length+1];
		int max = createMatrix(c, X, Y);
		System.out.println(max);
	}
}
