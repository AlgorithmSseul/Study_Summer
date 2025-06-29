
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박병호_2156 { //메모리ㅣ 14940kb   시간 128ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wineNum = Integer.parseInt(br.readLine());

        int[] wine = new int[wineNum + 1];  //보기 편하게 +1 해준다
        for (int i = 1; i <= wineNum; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (wineNum == 1) {   //와인잔의 개수가 1,2인 경우 dp값으로 출력하기 힘들어서 따로 설정을 해주고 출력
            System.out.println(wine[1]);  //한잔일 경우 그 잔의 값만 출력
            return;
        } else if (wineNum == 2) {    //두잔일 경우 연속 두잔까지 허용이므로 두잔의 합을 출력
            System.out.println(wine[1] + wine[2]);
            return;
        }

        int[] dp = new int[wineNum + 1];  //값을 저장할 배열을 생성해주고 초기값 설정
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        dp[3] = Math.max(dp[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));
        //세 번째 잔의 경우 경우의 수가 총 세가지이므로 그중 최대값으로 dp값을 저장해준다.

        //각 인덱스 잔에 올수 있는 경우의 수
        //1.해당 잔을 마시지 않는다. 이 경우 이전 잔의 최대값 dp[i-1]
        //2.전 잔을 마시지 이번 잔을 마신 값  전전잔의 최대값 + 현재 잔 dp[i - 2] + wine[i]
        //3.전잔과 이번 잔을 마신 값 전전전 잔의 최대값 +전 잔의 값 +현재 잔의 값  dp[i - 3] + wine[i - 1] + wine[i]
        //다른 경우의 수가 없는 이유  연속 3잔이 불가능 하기에 이어지는 세잔 중 한 잔은 무조건 마셔야 최대값이 나오기에 다른 경우의 수는 필요X
        //반복문으로 이 경우의 수 중 최대값을 구해 dp배열에 저장
        for (int i = 4; i <= wineNum; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])
            );
        }
        System.out.println(dp[wineNum]);
    }
}
//문제 풀이 비고
//수요일에 있던 계단 오르기(4월에 풀었던 문제)와 유사해 보여 그 문제 풀이 방식과 비슷하게 접근을 하였으나
//다른 점이 꽤 있었습니다. 계단 오르기는 연속으로 계단을 건너지 않았다면 해당 인덱스의 계단을 무조건 밟아야 하지만
//하지만 포도주 마시기는 연속으로 안마실 수도 있다는 경우의 수가 존재 했기에 점화식을 다르게 설정 해야 했고
//여기서는 인공지능 자식의 도움을 받았습니다.
//최초의 풀이는 2차원 배열을 사용했는데 보기 불편해서 1차원 배열로 인공지능이 바꿔서 이대로 제출합니다.