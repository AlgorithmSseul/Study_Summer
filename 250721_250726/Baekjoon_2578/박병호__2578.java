package Baekjoon_2578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 박병호__2578 {  //메모리 14268kb  시간 100ms
    static boolean[][] bingoCheck;  //빙고 개수 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] myBingo = new int[5][5];  //내 빙고 판
        bingoCheck = new boolean[5][5];  //빙고판 체크
        List<Integer> mcCall = new ArrayList<>(); //사회자가 부르는 숫자
        int answer = 0;
        for (int i = 0; i < 5; i++) {  //내 빙고판에 숫자 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                myBingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {  //사회자가 부를 번호 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                mcCall.add(Integer.parseInt(st.nextToken()));
            }
        }
        boolean check = false;
        for (int i = 0; i < mcCall.size(); i++) {  //사회자가 번호를 부르면 체크
            int num = mcCall.get(i);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (num == myBingo[j][k]) {
                        bingoCheck[j][k] = true;
                        if (i >= 11) {  //빙고를 달성할 수 있는 최소 횟수가 12회이므로 12번째 부름 부터 빙고 카운트
                            check = bingoCount(bingoCheck); //빙고를 달성하면  true 반환
                        }
                        if (check) {  //0부터 시작함으로 +1해주고 정답 저장
                            answer = i + 1;
                            break;
                        }
                    }
                }
                if (check) {
                    break;
                }
            }
            if (check) {
                break;
            }
        }
        System.out.println(answer);
    }

    static boolean bingoCount(boolean[][] bingoCheck) {

        int allBingo = 0;
        int crossCnt1 = 0;
        int crossCnt2 = 0;
        for (int i = 0; i < bingoCheck.length; i++) {
            int xCnt = 0;
            int yCnt = 0;
            for (int j = 0; j < bingoCheck.length; j++) {
                if (bingoCheck[i][j]) {  //x축 빙고 카운트
                    xCnt++;
                }
                if (bingoCheck[j][i]) {  //y축 빙고 카운트
                    yCnt++;
                }
            }
            if (xCnt == 5) {  //한줄 완성이면 빙고 ++
                allBingo++;
            }
            if (yCnt == 5) {  // ""
                allBingo++;
            }
            if (bingoCheck[i][i]) {  //대각선 빙고 체크
                crossCnt1++;
            }
            if (bingoCheck[i][4 - i]) {  // ""
                crossCnt2++;
            }
        }

        if (crossCnt1 == 5) {  //대각선 빙고 완성이면 빙고++
            allBingo++;
        }
        if (crossCnt2 == 5) {  // ""
            allBingo++;
        }
        if (allBingo >= 3) {  //3개 이상 이면 true 반환
            return true;
        } else {
            return false;
        }
    }
}
