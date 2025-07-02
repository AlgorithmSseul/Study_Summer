import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 김규빈_2493 {
	
	public static class Tower{
		int index;
		int height;
		Tower(int index, int height){
			this.index = index;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Tower> towers = new Stack<>();
		int[] results = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			
			int curHeight = Integer.parseInt(st.nextToken());
			
			while(!towers.isEmpty()) {
				int tmpHeight = towers.peek().height;
				if(tmpHeight >= curHeight) {
					results[i] = towers.peek().index;
					break;
				}
				else {
					towers.pop();
				}
			}
			
			towers.push(new Tower(i + 1, curHeight));
		}

		for (int i = 0; i < N; i++) {
			System.out.print(results[i] + " ");
		}
	}
}
