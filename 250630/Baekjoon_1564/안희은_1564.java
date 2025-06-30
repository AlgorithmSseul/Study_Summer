import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // int 범위보다 클 수도(N <= 1,000,000)
        long result = 1;
        
        // 팩토리얼 계산
        for (int i = 2; i <= n; i++) {
            result *= i;

            // 0 제거
            while (result % 10 == 0) {
                result /= 10;
            }
            
            // 시간 초과 나서 지쌤에게 자문 구함...
            // 숫자가 너무 커지는 걸 방지 (뒤 5자리에만 영향 없도록 충분히 큰 수)
            result %= 1000000000000L;
            
        }
        
        // 끝에서 5자리 출력
        String sN = Long.toString(result);
        System.out.printf(sN.substring(sN.length()-5, sN.length()));
    }
}

// 풀이방법
/* 첨에 재귀로 팩토리얼 구했는데.. 시간초과
 * 이 문제는 10^n 이걸로 나눠서 숫자를 0을 줄여나가 되는듯
 * 아직도 왜 10^12로 나눠야 되는지 몰겠음ㅜㅜ
 */
