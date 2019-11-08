package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_2617_구슬찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, Set> heavy = new HashMap<Integer, Set>();
		Map<Integer, Set> light = new HashMap<Integer, Set>();
		
		for (int i = 0; i <= N; i++) {
			heavy.put(i, new HashSet<>());
			light.put(i, new HashSet<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			heavy.get(s).add(f);
			light.get(f).add(s);
		}
		for (int i = 1; i <= N; i++) {
			Set temp = heavy.get(i);
			Object[] tt = temp.toArray();
			for(int a=0; a<tt.length; a++) {
				heavy.get(i).addAll(heavy.get(tt[a]));
			}
			Set templ = light.get(i);
			tt = templ.toArray();
			for(int a=0; a<tt.length; a++) {
				light.get(i).addAll(light.get(tt[a]));
			}
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(heavy.get(i).size() >= N/2+1 || light.get(i).size() >= N/2+1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
