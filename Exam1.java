package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1 {

	static boolean permutation(String a,String b) {
		if(a.length() != b.length()) {
			return false;
		}

		//文字列aのASCIIコードのリストを作る
		int[] letters = new int[256]; //ASCIIコード
		char[] a_array = a.toCharArray();
		for(char c:a_array) {
			letters[c]++;
		}

		//文字列bと文字列aを比較する
		for(int i=0;i<b.length();i++) {
			int c = (int)b.charAt(i);
			if(--letters[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		System.out.println("文字列aを入力してください。");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String a = br1.readLine();

		System.out.println("文字列bを入力してください。");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String b = br2.readLine();

		System.out.println(permutation(a ,b));
	}
}