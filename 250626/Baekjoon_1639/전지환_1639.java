// No.1639

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전지환_1639 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int maxLen = 1;
		char[] chars = br.readLine().toCharArray();
		int[] nums = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			nums[i] = chars[i] - 48; // 자릿수별로 숫자를 받아오기
		}
		
		int idx = 0; // 현재 시작점 위치
		boolean isChanged = false; // 한번이라도 비교 통과를 했는지 체크
		if (nums.length == 1) {
			System.out.print(0); // 애초에 한자릿수면 답은 무조건 0
			return;
		} else {
			while (nums.length + 1 > (maxLen*2) + idx) { // 현재 최대 부분길이 + 시작점 <= 전체길이 동안 반복
				int len = maxLen; // 현재까지 최대 길이를 대입
				while (nums.length + 1 > (len*2) + idx) { // 현재 부분길이 + 시작점 <= 전체길이 동안 반복
					int sumA = 0; // 왼쪽 N자리 합
					int sumB = 0; // 오른쪽 N자리 합
					for (int i = 0; i < len; i++) {
						sumA += nums[i+idx]; // 왼쪽 N자리 합
						sumB += nums[i+idx+len]; // 오른쪽 N자리 합
					}
					if (sumA == sumB) { // 왼쪽 N자리 합 == 오른쪽 N자리 합
						maxLen = len; // 현재 부분길이가 지금까지 중 최대 부분길이
						isChanged = true;
					}
					len++; // 다음 길이 체크
				}
				idx++; // 다음 시작점 체크
			}						
		}
		
		if (!isChanged) maxLen = 0; // 한번도 왼쪽 N자리 합 == 오른쪽 N자리 합이 되지 않았다면 최대길이 = 0
		System.out.print(maxLen*2); // 전체 최대 부분길이 출력
	} // main

}