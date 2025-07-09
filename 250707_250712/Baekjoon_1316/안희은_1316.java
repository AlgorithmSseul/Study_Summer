import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 메모리: 11600 KB, 시간: 68 ms
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());  // 입력 단어 개수
		int result = 0;  // 그룹 단어가 아닌 단어의 개수

		for (int i = 0; i < n; i++) {
			String word = br.readLine();          // 단어 입력
			int[] used = new int[26];             // 알파벳 사용 여부 저장 (a~z → 0~25 인덱스)
			
			char prevChar = 0;                    // 직전 알파벳 저장용
			
			for (int j = 0; j < word.length(); j++) {
				char currentChar = word.charAt(j);  // 현재 알파벳
				
				// 이전 알파벳과 다를 경우 (새로운 알파벳 등장 시)
				if (prevChar != currentChar) {
					
					// 이미 등장한 적 있는 알파벳이면 그룹 단어가 아님
					if (used[currentChar - 'a'] >= 1) {
						result++;  // 그룹 단어가 아닌 것으로 카운트
						break;
					}
					
					// 처음 등장하는 알파벳이면 사용 기록하고 prevChar 갱신
					used[currentChar - 'a']++;
					prevChar = currentChar;
				}
			}
		}
		
		// 전체 단어 수 - 그룹 단어가 아닌 개수 = 그룹 단어 개수
		System.out.println(n - result);
	}
}
