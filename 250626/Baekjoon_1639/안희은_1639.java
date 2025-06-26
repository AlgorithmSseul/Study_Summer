import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine(); // 티켓번호
		int n = S.length(); // 전체 길이

		for (int len = n; len >= 2; len--) {
			if (len % 2 != 0)
				continue; // 홀수 길이는 건너뜀

			for (int i = 0; i + len <= n; i++) {
				if (check(i, i + len)) { // 왼쪽, 오른쪽 합이 같은지 확인
					System.out.println(len);
					return; // 바로 종료
				}
			}
		}
		System.out.println(0);

	}

	// 합 확인 함수
	static boolean check(int L, int R) {
		int mid = (L + R) / 2; // 구간의 반
		int sumL = 0, sumR = 0;

		// 왼쪽 합
		for (int i = L; i < mid; i++) {
			sumL += S.charAt(i) - '0';
		}
		// 오른쪽 합
		for (int i = mid; i < R; i++) {
			sumR += S.charAt(i) - '0';
		}
		// 같은지 확인
		return sumL == sumR;
	}

}
