import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 쓰레기차 용량
            int N = Integer.parseInt(st.nextToken()); // 지점 수

            int[] x = new int[N]; // 거리
            int[] w = new int[N]; // 쓰레기 양

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                w[i] = Integer.parseInt(st.nextToken());
            }

            int distance = 0;     // 총 이동 거리
            int capacity = W;     // 현재 잔여 용량
            int i = 0;            // 현재 지점 인덱스

            while (i < N) {
                if (w[i] == 0) {
                    i++;
                    continue;
                }

                if (w[i] == capacity) {
                    // 정확히 채움, 왕복 후 다음 지점
                    distance += 2 * x[i];
                    capacity = W;
                    i++;
                } else if (w[i] < capacity) {
                    // 현재 지점 쓰레기를 실을 수 있음, 잔여 용량 감소
                    capacity -= w[i];
                    i++;
                } else {
                    // 실을 수 없음, 먼저 비우러 갔다가 다시 와야 함
                    distance += 2 * x[i];
                    capacity = W;
                }
            }

            // 마지막에 잔여 쓰레기 있으면 최종 왕복
            if (capacity < W) {
                distance += 2 * x[N - 1];
            }

            System.out.println(distance);
        }
    }
}
