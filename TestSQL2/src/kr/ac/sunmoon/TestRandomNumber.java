package kr.ac.sunmoon;

import java.util.Random;

public class TestRandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int n = rand.nextInt(13);
		System.out.println(n);
	}

}
