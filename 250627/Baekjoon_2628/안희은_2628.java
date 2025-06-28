import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {  //11620KB, 68ms	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로, 세로
		int width = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		// 반복
		int n = Integer.parseInt(br.readLine());

		int[] arrWid = new int[100]; // 세로 자르기 좌표
		int[] arrLen = new int[100]; // 가로 자르기 좌표
		int widIdx = 0;
		int lenIdx = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			if (k == 0) {
				arrLen[lenIdx++] = val; // 가로 자르기
			} else {
				arrWid[widIdx++] = val; // 세로 자르기
			}
		}
		
		// 시작점,끝점 추가
		arrLen[lenIdx++] = 0;
		arrLen[lenIdx++] = length;

		arrWid[widIdx++] = 0;
		arrWid[widIdx++] = width;

		// 정렬을 좀 더 효율적으로 하려면 절단(메모리 낭비 줄이기)
		int[] cutLen = Arrays.copyOf(arrLen, lenIdx);
		int[] cutWid = Arrays.copyOf(arrWid, widIdx);

		// 정렬
		Arrays.sort(cutLen);
		Arrays.sort(cutWid);

		// 가장 큰 길이 찾기
		int maxL = 0;
		int maxW = 0;
		for (int i = 1; i < lenIdx; i++) {
			maxL = Math.max(maxL, cutLen[i] - cutLen[i - 1]);
		}
		for (int i = 1; i < widIdx; i++) {
			maxW = Math.max(maxW, cutWid[i] - cutWid[i - 1]);
		}

		System.out.println(maxL * maxW);

	}

}

// 풀이 방법
/* 자르는 좌표 가로, 세로 배열에 넣기
 * 배열 정렬해서 차이 구하기
 * 길이 차이가 큰 것들 가지고 면적 구하면 최대 면적!
*/

// 코드 개선 방법
/* Arrays.copyOf(arrLen, lenIdx); 이 함수로 필요한 부분만 가지고 와서 정렬 했다면
 * Arrays.sort(array, fromIndex, toIndex); 함수에 시작과 끝 위치 정하는게 있어서 이렇게 하면
 * 코드 길이 줄일 수 있음
 */
