import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 김규빈_1639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();

        // 최대 길이부터 시작해서 줄여나감
        for (int len = N; len >= 2; len--) {
            if (len % 2 != 0) continue; // 홀수 건너뜀

            for (int i = 0; i <= N - len; i++) {
                String sub = str.substring(i, i + len);
                if (isLucky(sub)) {
                    System.out.println(len);
                    return; 
                }
            }
        }

        System.out.println(0); // 찾지 못한 경우 0 반환 
    }

    private static boolean isLucky(String str) {
        int half = str.length() / 2;
        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < half; i++) {
            leftSum += str.charAt(i) - '0';
        }
        for (int i = half; i < str.length(); i++) {
            rightSum += str.charAt(i) - '0';
        }

        return leftSum == rightSum;
    }
}
