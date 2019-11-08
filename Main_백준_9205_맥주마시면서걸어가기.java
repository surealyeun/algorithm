package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class position{
	int x;
	int y;
	public position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main_백준_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			position[] pin = new position[N+2];
			boolean[] visit = new boolean[N+2];
			for (int i = 0; i < pin.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pin[i] = new position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} // input
			
			position start = pin[0];
			position end = pin[N+1];
			
			Queue<position> q = new LinkedList<>();
			
			q.add(start);
			boolean flag = false;
			while(!q.isEmpty()) {
				
				for (int i = 1; i < pin.length-1; i++) {
					for (int j = i+1; j < pin.length; j++) {
						
					}
				}
				
				
			}
			if(flag) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
	}
}
