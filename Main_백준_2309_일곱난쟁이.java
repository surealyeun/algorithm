/**
 * 난쟁이 7명 찾기
 */
package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_백준_2309_일곱난쟁이 {
	public static int[] dw;
	public static List<Integer> re;
	public static int top = -1;
	public static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dw = new int[9];
		sum = 0;
		for (int i = 0; i < 9; i++) {
			dw[i] = Integer.parseInt(br.readLine());
			sum += dw[i];
		}
		int a=0;
		int b=0;
		re = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				sum = sum-dw[i]-dw[j];
				if(sum == 100) {
					a=dw[i];
					b=dw[j];
					break;
				}
				sum = sum+dw[i]+dw[j];
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if(dw[i] != a && dw[i] != b) {
				re.add(dw[i]);
			}
		}
		
		Collections.sort(re);
		for(int i=0; i<7; i++) {
			System.out.println(re.get(i));
		}
	}//end of main
}
