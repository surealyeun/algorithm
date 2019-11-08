/**
 * 미로탐색
 */
package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2178_미로탐색 {
	public static int[][] miro;
	public static boolean[][] miroB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		  
		miro = new int[N+2][M+2];
		miroB = new boolean[N+2][M+2];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=M; j++) {
				miro[i][j] = (str.charAt(j-1)=='0'? 0 : 1);
				miroB[i][j] = (str.charAt(j-1)=='0'? true : false);
			}
		}
		
		int[][] q = new int[10000][2]; 
		int f = -1; int r = -1;
		int x = 1; int y = 1;
		int[][] move = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
		
		q[++r][0] = x;
		q[r][1] = y;
		
		while(x != N || y != M) {
			x = q[++f][0];//큐에서 꺼냄
			y = q[f][1];
			miroB[x][y] = true; //방문 표시
			for(int i=0; i<4; i++) {
				if(miro[x+move[i][0]][y+move[i][1]] == 1 && miroB[x+move[i][0]][y+move[i][1]] == false) {
					q[++r][0] = x+move[i][0];
					q[r][1] = y+move[i][1];
					miroB[x+move[i][0]][y+move[i][1]] = true;
					miro[x+move[i][0]][y+move[i][1]] = miro[x][y] + 1;
				}
			}
			
		}
		System.out.println(miro[N][M]);
		
	}//end of main
}

