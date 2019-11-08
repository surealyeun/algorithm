package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1463_1로만들기 {
	public static int cnt;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		make1(x);
		System.out.println(min);
	}
	
	public static void make1(int x) {
		if(x==1) {
			if(cnt < min) {
				min = cnt;
			}
			return;
		}else {
			if(x%3 == 0 && min > cnt) {
				cnt++;
				make1(x/3);
				cnt--;
			}
			if(x%2 == 0 && min > cnt) {
				cnt++;
				make1(x/2);
				cnt--;
			}
			if (x > 1 && min > cnt) {
				cnt++;
				make1(x - 1);
				cnt--;
			}
		}
	}
}
