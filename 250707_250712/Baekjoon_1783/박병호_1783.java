package Baekjoon_1783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박병호_1783 {//메모리14240kb  시간 104ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //문제의 핵심은 나이트가 병들어서 오른쪽으로 갈 수 밖에 없다는 점
        // 이를 좌표로 말하면 X좌표 마다 닿을 수 있는 나이트의 범위는 1아님 0
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //나이트가 4번이상 이동할 때만 4가지 방법을 다 써야 한다는건
        //4가지 방법을 다쓴 후라면 2번만 오른쪽으로 두칸 이동 후 한칸씩 오른쪽으로 이동하는 것이 최대값일 것
        int[] illKnight = new int[8];  //그렇기에 4번 이동하지 않는 범위의 답만 미리 구해서 저장
        illKnight[1] = 1;    //방법 4가지를 다쓰면 1부터 2,2,1,1이동해서 7이므로 7미만의 경우의 답을 저장
        illKnight[2] = 2;
        illKnight[3] = 3;
        illKnight[4] = 4;
        illKnight[5] = 4;
        illKnight[6] = 4;

        if (N == 1) {  //N이 1일 경우 그 어떤 방법도 쓸 수 없으므로 시작점 1이 끝
            System.out.println(1);
        } else if (N == 2) { //N이 2일 경우 위로 두 칸 가는 방법은 쓸 수 없고 그렇기에 3번 밖에 이동 할 수 없으므로 M이 7이상이면 4로 고정
            if (M < 7) { //7미만일 경우 짝 수일경우 /2 값 홀수면 /2+1값을 출력
                if (M % 2 == 0) {
                    System.out.println(M / 2);
                } else {
                    System.out.println(M / 2 + 1);
                }
            } else {
                System.out.println(4);
            }
        } else {
            if (M < 7) {  //N이 3이상이라면 4가지 방법 모두 사용 할 수 있으므로 7미만이면 저장한 답 출력
                System.out.println(illKnight[M]);
            } else {
                System.out.println(M - 2); //7이상 일 경우 두칸이동을 처음 2번만 해주면 계속 한칸씩 이동
                //가능 하니 M 길이의 -2한 값이 답이다.
            }
        }
    }
}
