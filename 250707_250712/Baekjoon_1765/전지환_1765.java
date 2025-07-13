/*
 * 성능 요약
 * 메모리: 23696 KB, 시간: 336 ms
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max;
	static Student[] students;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		students = new Student[N+1];
		for (int i = 1; i <= N; i++) {
			students[i] = new Student(new ArrayList<>(), new ArrayList<>());
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			char rela = st.nextToken().charAt(0);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			switch (rela) {
			case 'F':
				students[A].F.add(B);
				students[B].F.add(A);
				break;
			case 'E':
				students[A].E.add(B);
				students[B].E.add(A);
				break;
			}
		} // students 만들기
		
		visited = new boolean[N+1];
		max = 0;
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			dfs(i);
			max++;
		}
		System.out.print(max);
		
	} // main
	
	static void dfs(int v) {
		visited[v] = true;
		
		for (int i = 0; i < students[v].E.size(); i++) {
			for (int j = 0; j < students[students[v].E.get(i)].E.size(); j++) {
				int EE = students[students[v].E.get(i)].E.get(j);
				if (visited[EE]) continue;
				dfs(EE);
			}
		}
		
		for (int i = 0; i < students[v].F.size(); i++) {
			int F = students[v].F.get(i);
			if (visited[F]) continue;
			dfs(F);
		}
	}

	static class Student {
		List<Integer> F;
		List<Integer> E;
		public Student(List<Integer> f, List<Integer> e) {
			F = f;
			E = e;
		}
	}
	
	
	
}
