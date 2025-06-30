import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numA = Integer.parseInt(st.nextToken());
		int numB = Integer.parseInt(st.nextToken());
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int a = 0; a<numA; a++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int b = 0; b<numB; b++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		// 교집합
		Set<Integer> intersection = new HashSet<>(A);
		intersection.retainAll(B);
		
		// 합집합
		Set<Integer> union = new HashSet<>(A);
		union.addAll(B);
		
		// 합집합 개수 - 교집합 개수
		int size = union.size()-intersection.size();
		System.out.println(size);
	}

}

// 풀이방법
// 대칭 차집합 개수는 합집합 개수에서 교집합 개수 뺀 거!
