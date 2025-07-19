package Baekjoon_1680;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박병호_1680 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());  //가능 무게
            int humanNum = Integer.parseInt(st.nextToken()); //쓰레기 개수

            int[][] thanos = new int[humanNum][2];  //쓰레기의 거리와 무게 저장
            for (int i = 0; i < humanNum; i++) {
                st = new StringTokenizer(br.readLine());
                thanos[i][0] = Integer.parseInt(st.nextToken());
                thanos[i][1] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            int ableHumanWeight = weight; //현재 올릴 수 있는 무게
            int index = 0;

            while (index < humanNum) { //마지막 쓰레기 위치까지 가도록
                int dist = thanos[index][0]; //현재 거리
                int hamanWeight = thanos[index][1]; //현재 차에 싫은 쓰레기 무게

                if (ableHumanWeight == hamanWeight) { //가능한 만큼 다 채웠으면 거리를 추가하고 초기화
                    answer += 2 * dist; //버리러 쓰레기장을 갔다와야 하기 때문에 왕복 거리 더해줌
                    ableHumanWeight = weight;
                    index++;
                } else if (ableHumanWeight > hamanWeight) { //쓰레기 여유 분이 있다면
                    ableHumanWeight -= hamanWeight;//가능한 쓰레기 양을 그만큼 빼주고 다음 쓰레기를 향해
                    index++;
                } else {
                    answer += 2 * dist;  //초과인경우 왕복으로 한번 갔다온 후 다시 쓰레기를 채움
                    ableHumanWeight = weight; //그렇기에 인덱스는 증가하지 않음 똑같은 곳을 가야하기에
                }
            }
            if (ableHumanWeight < weight) { //마지막 쓰레기 장에 갔을 때 쓰레기가 남는 경우 위의 조건문에서 무게 증가를 하지 않기 때문에 여기서 추가 해줌
                answer += 2 * thanos[humanNum - 1][0];
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
