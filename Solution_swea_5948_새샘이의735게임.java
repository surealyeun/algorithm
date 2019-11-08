/**
 * 새샘이의 7-3-5 게임
 */
package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_swea_5948_새샘이의735게임 {
	public static Set<Integer> res;
	public static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums = new int[7];
			res = new HashSet<>();
			for (int j = 0; j < nums.length; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
				
			for (int j = 0; j < 7; j++) {
				for (int k = j+1; k < 7; k++) {
					for (int l = k+1; l < 7; l++) {
						res.add(nums[j]+nums[k]+nums[l]);
					}
				}
			}
			List<Integer> resl = new ArrayList(res);
			Collections.sort(resl);
			Collections.reverse(resl);
			System.out.println("#"+i+" "+resl.get(4));
		}
	}
	
}
