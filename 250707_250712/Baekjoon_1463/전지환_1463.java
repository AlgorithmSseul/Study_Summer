/*
 * 성능 요약
 * 메모리: 14332 KB, 시간: 144 ms
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		dfs(X, 0);
		
		System.out.print(min);
		
	}

	private static void dfs(int x, int count) {
		if (x == 1) {
			min = Math.min(min, count);
			return;
		}
		
		if (count >= min) {
			return;
		}
		
		if (x % 3 == 0) {
			dfs(x/3, count + 1);
		}
		if (x % 2 == 0) {
			dfs(x/2, count + 1);
		}
		dfs(x-1, count + 1);
	}

}
