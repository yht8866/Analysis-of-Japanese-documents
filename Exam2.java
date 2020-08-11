package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exam2 {

	static void next_permutation(char[] p, int n, int r, int num) {
		int i, j, k;
		int o = 1;
		char t;

		if (r <= 0 || n < r) {
			return;
		}

		if(o == num) {
			print_p(p, r);
			return;
		}

		for (i = 1; i < num; i++) {
			for (j = n - 1; j > 0 && p[j-1] >= p[j]; j--);
			if (j == 0) {
				return;
			}
			for (k = n - 1; k > j && p[j-1] >= p[k]; k--);
			t = p[k]; p[k] = p[j-1]; p[j-1] = t;
			for (k = n - 1; j < k; j++, k--) {
				t = p[j]; p[j] = p[k]; p[k] = t;
			}
		}
		print_p(p, r);
		return;
	}

	static void print_p(char[] p, int r) {
		String s = "";
		for (char c : p) {
			s += c;
		}
		System.out.println(s);
	}

    public static void main(String[] args) throws IOException {

		System.out.println("文字列を入力してください。");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String P1 = br1.readLine();
		int N = P1.length();
		int R = N;
		char[] p = P1.toCharArray();
		Arrays.sort(p);

		System.out.println("順番を入力してください。");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String P2 = br2.readLine();
		int num = Integer.parseInt(P2);

		next_permutation(p, N, R, num);
	}
}