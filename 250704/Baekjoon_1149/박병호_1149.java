package Baekjoon_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 박병호_1149 { //메모리 14468 시간 112
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];  //집 개수 만큼 비용 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N; i++) {  //문제의 조건은 길지만 단순 요약 하면 바로 전 색과 겹치 지만 않으면 ok
            for (int j = 0; j < 3; j++) {  //현재 집에서 색 마다 최저 비용을 구한다.
                if (j == 0) {
                    house[i][0] = Math.min(house[i - 1][1] + house[i][j], house[i - 1][2] + house[i][j]); //빨간색으로 칠한 다면 이전 집까지 칠한 비용중 이전 색이 초록,파랑 인 값들을 더해서 비교후 저장
                } else if (j == 1) {
                    house[i][1] = Math.min(house[i - 1][0] + house[i][j], house[i - 1][2] + house[i][j]); //""
                } else if (j == 2) {
                    house[i][2] = Math.min(house[i - 1][0] + house[i][j], house[i - 1][1] + house[i][j]); //""
                }
            }
        }
        int answer = Math.min(house[house.length - 1][0], Math.min(house[house.length - 1][1], house[house.length - 1][2])); //마지막 집까지 칠한 비용중 가장 적은 비용 출력
        System.out.println(answer);
    }
}
