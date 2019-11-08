package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16236_아기상어 {
	public static int[][] map;
	public static int sk;
	public static int d;
	public static int eat;
	public static Queue<node> q;
	public static boolean[][] visit;
	public static int[][] move;
	
	public static class node {
		int x;
		int y;
		
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int x = -1;
		int y = -1;
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}
		sk = 2;
		d = 0;
		eat = 0;
		bfs(x, y);
		System.out.println(d);
	}// end of main
	
	public static void bfs(int x, int y) {
		q = new LinkedList<node>();
		q.add(new node(x,y));
		visit = new boolean[map.length][map.length];
		move = new int[map.length][map.length];
		visit[x][y] = true;
		int[][] fish = new int[10000][3];
		int fishcnt = 0;
		while (!q.isEmpty()) {
			node a = q.poll();
			// up
			if (a.x - 1 >= 0 && map[a.x - 1][a.y] >= 0 && map[a.x - 1][a.y] <= sk && !visit[a.x-1][a.y] ) {
				if (map[a.x - 1][a.y] > 0 && map[a.x - 1][a.y] < sk) { // 물고기 발견
					move[a.x-1][a.y] = move[a.x][a.y]+1;
					fish[fishcnt][0] = a.x-1;
					fish[fishcnt][1] = a.y;
					fish[fishcnt++][2] = move[a.x-1][a.y];
				} else {
					visit[a.x-1][a.y] = true;
					move[a.x-1][a.y] = move[a.x][a.y]+1;  
					q.add(new node(a.x - 1, a.y));
				}
			}
			// left
			if (a.y - 1 >= 0 && map[a.x][a.y - 1] >= 0 && map[a.x][a.y - 1] <= sk && !visit[a.x][a.y-1]) {
				if (map[a.x][a.y - 1] > 0 && map[a.x][a.y - 1] < sk) {
					move[a.x][a.y-1] = move[a.x][a.y]+1;
					fish[fishcnt][0] = a.x;
					fish[fishcnt][1] = a.y-1;
					fish[fishcnt++][2] = move[a.x][a.y-1];
				} else {
					visit[a.x][a.y-1] = true;
					move[a.x][a.y-1] = move[a.x][a.y]+1;  
					q.add(new node(a.x, a.y - 1));
				}
			}
			// right
			if (a.y + 1 < map.length && map[a.x][a.y + 1] >= 0 && map[a.x][a.y + 1] <= sk && !visit[a.x][a.y+1]) {
				if (map[a.x][a.y + 1] > 0 && map[a.x][a.y + 1] < sk) { // 물고기 발견
					move[a.x][a.y+1] = move[a.x][a.y]+1;
					fish[fishcnt][0] = a.x;
					fish[fishcnt][1] = a.y+1;
					fish[fishcnt++][2] = move[a.x][a.y+1];
				} else {
					visit[a.x][a.y+1] = true;
					move[a.x][a.y+1] = move[a.x][a.y]+1;  
					q.add(new node(a.x, a.y + 1));
				}
			}
			// down
			if (a.x + 1 < map.length && map[a.x + 1][a.y] >= 0 && map[a.x + 1][a.y] <= sk && !visit[a.x+1][a.y]) {
				if (map[a.x + 1][a.y] > 0 && map[a.x + 1][a.y] < sk) {
					move[a.x+1][a.y] = move[a.x][a.y]+1;
					fish[fishcnt][0] = a.x+1;
					fish[fishcnt][1] = a.y;
					fish[fishcnt++][2] = move[a.x+1][a.y];
				} else {
					visit[a.x+1][a.y] = true;
					move[a.x+1][a.y] = move[a.x][a.y]+1;  
					q.add(new node(a.x + 1, a.y));
				}

			}

		} // end of while
		if (fishcnt > 0) {
			// 물고기중 가장 가까운 거리
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < fishcnt; i++) {
				if (min > fish[i][2]) {
					min = fish[i][2];
				}
			}
			// 가까운 물고기중 행 작은거
			int minr = Integer.MAX_VALUE;
			for (int i = 0; i < fishcnt; i++) {
				if (fish[i][2] == min && fish[i][0] < minr) {
					minr = fish[i][0];
				}
			}
			// 행 작은거 중 열 작은거
			int minc = Integer.MAX_VALUE;
			for (int i = 0; i < fishcnt; i++) {
				if (fish[i][2] == min && fish[i][0] == minr && fish[i][1] < minc) {
					minc = fish[i][1];
				}
			}

			d += min;
			map[minr][minc] = 0;
			eat++;
			if (eat == sk) {
				sk++;
				eat = 0;
			}
			bfs(minr, minc);
		}
	}// end of bfs
}
