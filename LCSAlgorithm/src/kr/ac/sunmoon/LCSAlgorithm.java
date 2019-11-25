package kr.ac.sunmoon;

public class LCSAlgorithm {
	private static String[] X = {"음악", "음식", "여행", "야구", "만화"};
	private static String[] Y = {"여행", "야구", "음악", "음식", "독서"};
	private static int[][] c = new int[X.length+1][Y.length+1];
	public static int[][] createMatrix(int[][] c) {
		for(int i=1; i<X.length+1; i++) {
 			for(int j=1; j<Y.length+1; j++) {
				if(X[i-1].equals(Y[j-1]))
					c[i][j] = c[i-1][j-1] + 1;
				else
					c[i][j] = Math.max(c[i][j-1], c[i-1][j]);
			}
		}
		return c;
	}
	public static void printArray(int[][] c) {
		for(int i=0; i<c.length; i++) {
			for(int j=0; j<c[i].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		int[][] matrix = createMatrix(c);
		printArray(matrix);
		System.out.println(c[X.length][Y.length]);
	}
}
