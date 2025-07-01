import java.io.*;
import java.util.*;

public class Main {
	static int[] countN = new int[3]; // -1,0,1 개수 저장 배열
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		paper = new int[n][n]; // 종이 배열

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 종이 자르기 함수 호출
		divide(0, 0, n);

		for (int k = 0; k < 3; k++) {
			System.out.println(countN[k]);
		}

	}

	// 숫자가 같은지 확인
	static boolean checkSame(int x, int y, int size) {

		int num = paper[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				// 다르면 false 값 반환
				if (paper[i][j] != num) {
					return false;
				}
			}
		}

		// 다른게 없으면 true 값 반환
		return true;

	}

	// 종이 자르는 함수
	static void divide(int x, int y, int size) {
		// 숫자가 다 같았으면
		if (checkSame(x, y, size)) {
			// 개수+1
			countN[paper[x][y] + 1]++;
			return;
		}
		// 자름
		int newSize = size / 3;
		// 9조각으로 나누기 때문에 가로 3, 세로 3으로 나눔
		for (int dx = 0; dx < 3; dx++) {
			for (int dy = 0; dy < 3; dy++) {

				divide(x + dx * newSize, y + dy * newSize, newSize);
			}
		}

	}

}

// 풀이방법
/*
 * 재귀 사용!
 * 숫자가 같은지 확인하는 메소드랑 종이 자르는 함수 메소드 분리
 * 재귀 오랜만에 하니까 기저조건 설정하고 재귀 함수 매개변수 값 설정이 어려웠음
 */
