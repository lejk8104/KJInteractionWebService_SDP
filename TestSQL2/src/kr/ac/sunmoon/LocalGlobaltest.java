package kr.ac.sunmoon;

public class LocalGlobaltest {
//	private static int a;
//	private static int b;
	public void main(String[] args) {
		int a = 1;		
		int b = changeatob(a);
	}
	public int changeatob(int a) {
		a = 2;
		int b = a;
		return b;
	}

}
