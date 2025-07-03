package Baekjoon_1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 박병호_1205 { //메모리 14324  시간 104
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> scoreList = new ArrayList<>();
        if (N != 0) {   //현재 점수 판에 등록 된 점수를 입력, 점수가 없으면 입력값 자체가 없기에 조건을 잘 나눈다.
            StringTokenizer scoreInput = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scoreList.add(Integer.parseInt(scoreInput.nextToken()));
            }
        } else {  //점수가 아예 없는 경우 현재 태수의 점수 등록
            scoreList.add(score);
        }
        Collections.sort(scoreList, Collections.reverseOrder());  //내림차순으로 정렬

        int last = scoreList.get(scoreList.size() - 1);  //마지막 값 .=> 현재 게시판 꼴등 점수 저장

        if (last >= score && scoreList.size() != 1 && scoreList.size() == P) {  //태수의 점수가 꼴등보다 낮고 게시판 등록 점수가 꽉찬 상태이면 -1
            System.out.println(-1);
        } else {
            for (int i = 0; i < scoreList.size(); i++) {  //내림차순으로 정렬했기에 맨 앞부터 비교하여 같거나 자신이 더 크다면 현재 비교점수의 인덱스 +1이 이번 태수 점수의 등수
                if (scoreList.get(i) <= score) {
                    System.out.println(i + 1);
                    break;
                } else if (i == scoreList.size() - 1) { //끝까지 갔는데도 태수의 점수가 가장 낮다면 등록된 점수 중 가장 꼴찌 등수이므로 리스트 사이즈 +1 출력
                    System.out.println(scoreList.size() + 1);
                    break;
                }
            }
        }

    }
}