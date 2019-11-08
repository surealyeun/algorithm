package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14501_퇴사 {
	public static int[][] cns;
	public static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cns = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cns[i][0] = Integer.parseInt(st.nextToken());
			cns[i][1] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		plan(0,0);
		System.out.println(max);
	} // end of main
	
	public static void plan(int day, int pay) {
		if(day >= cns.length) {
			max = Math.max(max, pay);
			return;
		}else {
			plan(day+1, pay);
			if(day + cns[day][0] <= cns.length) {
				plan(day + cns[day][0], pay+cns[day][1]);
			}
		}
	}
}
