package Baekjoon_1927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class 박병호_1927 { //284ms  우선순위 큐 쓰면 되는 문제 스캐너와 버퍼리드차이가 크다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 첫 줄: 명령 개수

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine()); // 한 줄씩 정수 입력

            if (num != 0) {
                q.offer(num);
            } else {
                if (q.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
