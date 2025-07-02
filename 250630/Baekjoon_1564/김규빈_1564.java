import java.io.*;

public class 김규빈_1564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long result = 1;
        int twoCount = 0;
        int fiveCount = 0;
        int MOD = 100000;

        for (int i = 2; i <= N; i++) {
            int num = i;

            // 2와 5의 개수를 세서 제거
            while (num % 2 == 0) {
                twoCount++;
                num /= 2;
            }
            while (num % 5 == 0) {
                fiveCount++;
                num /= 5;
            }

            result = (result * num) % MOD;
        }

        // 남은 2와 5 중 차이만큼 2를 곱하거나 5를 곱한다
        int diff = twoCount - fiveCount;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                result = (result * 2) % MOD;
            }
        } else {
            for (int i = 0; i < -diff; i++) {
                result = (result * 5) % MOD;
            }
        }

        // 뒤에서 5자리 출력
        String resStr = String.valueOf(result);
        while (resStr.length() < 5) {
            resStr = "0" + resStr;
        }
        System.out.println(resStr);
    }
}
