package Baekjoon_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 박병호_2493 { //메모리 85340kb 시간 804ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Top = Integer.parseInt(br.readLine());  //탑의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> laserBeam = new Stack<>(); //왼쪽 부터 비교 해야 하니 스택을 쓴다
        //스택에는 탑의 높이가 아닌 해당 탑의 인덱스를 저장한다. 인덱스를 출력하는 문제이기에
        int[] topHeight = new int[Top]; //탑의 높이를 저장
        for (int i = 0; i < Top; i++) {
            topHeight[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < Top; i++) { //가장 왼쪽에 있는 탑부터 레이저 도달 지점 확인
            while (!laserBeam.isEmpty() && topHeight[laserBeam.peek()] <= topHeight[i]) {
                laserBeam.pop(); //만약에 현재 탑보다 낮은 탑이면 앞으로 비교 할 때 레이저 갈 일이 없어서 pop 해준다.
            }  //ex) 탑이 0 9 1 3 일 때 현재 탑이 9라면 왼쪽에 있는 탑 0은 9 오른쪽 1 ,3에서 쏜 레이저 도달 절대 못함
            if (laserBeam.isEmpty()) { //스택이 비면 왼쪽에 도달 가능 탑 X 니까 0
                sb.append(0).append(" ");
            } else {  //아닌 경우 peek으로 탑을 생존 시키고 인덱스 출력
                sb.append(laserBeam.peek() + 1).append(" ");
            }
            laserBeam.push(i);  //이 과정을 지나면 현재 탑의 인덱스를 스택에 넣는다.
        }

        System.out.println(sb); //출력 한다.
    }
}
//비고
//4달전이라 가물가물한데 처음에는 자료 구조 2개를 써서 풀었는데 백준에서는 시간 초과가 났었습니다.
//그 뒤에 여러 방법을 시도하다가 인공지능 도움을 받아서 이렇게 스택 하나로 풀었던 기억이 있습니다.
//다만 역량 평가 시간, 메모리 기준이 관대하니까 거기서는 자료 구조 두개를 써서 풀면 될 것 같습니다. 