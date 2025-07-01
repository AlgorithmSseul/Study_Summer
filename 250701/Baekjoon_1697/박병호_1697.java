package Baekjoon_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박병호_1697 {   //메모리 22528kb   시간 144ms

    static boolean[] visited;     //방문 배열 생성
    static int answer = 0;       //정답 출력할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[100001];
        int ifYouCan = Integer.parseInt(st.nextToken());   //술래
        int catchMe = Integer.parseInt(st.nextToken());    //잡히는 사람

        bfs(ifYouCan, catchMe);   //bfs해준다.

        System.out.println(answer);

    }

    static void bfs(int ifYouCan, int catchMe) {
        Queue<int[]> q = new LinkedList<>();   //큐에 넣는다
        q.add(new int[]{ifYouCan, 0});
        visited[ifYouCan] = true;

        while (!q.isEmpty()) {    //현재 위치가 목적지면 정답 저장 후 탈출
            int[] currentIndex = q.poll();
            int currentMe = currentIndex[0];
            int[] choice = {currentMe - 1, currentMe + 1, currentMe * 2};
            if (currentMe == catchMe) {
                answer = currentIndex[1];
                return;
            }
            for (int i = 0; i < choice.length; i++) {   //아니라면  -1 ,+1,*2했을 때의 값을 큐에 추가 해서 bfs를 반복한다.
                int next = choice[i];
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, currentIndex[1] + 1});
                }
            }
        }
    }
}
//예전에 풀었던 문제 인데 한 번 더 풀어보았습니다.