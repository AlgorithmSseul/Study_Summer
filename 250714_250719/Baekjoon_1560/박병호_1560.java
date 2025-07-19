package Baekjoon_1560;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class 박병호_1560 {//108ms   제가 푼건 아니고 풀다가 공식이 정해져 있다고 합니다.
    public static void main(String[] args) throws IOException {
        // 버퍼리더로 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 70자리까지 입력 가능

        BigInteger N = new BigInteger(input); //입력값이 커서 이걸 써야 한다 함

        if (N.equals(BigInteger.ONE)) {
            System.out.println(1); // N이 1이면 비숍 하나만 가능
        } else {
            BigInteger two = new BigInteger("2");
            BigInteger result = N.multiply(two).subtract(two); // 2N - 2
            System.out.println(result);
        }
    }
}
