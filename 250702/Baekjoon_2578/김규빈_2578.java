import java.io.*;
import java.util.*;

public class 김규빈_2578 {
    static int[][] board = new int[5][5];
    static boolean[][] marked = new boolean[5][5];
    static Map<Integer, int[]> map = new HashMap<>();  // 숫자 → 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                map.put(num, new int[]{i, j});
            }
        }

        // 사회자 수 순서 입력
        int count = 0;
        boolean done = false;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int call = Integer.parseInt(st.nextToken());
                count++;

                // 마크 처리
                int[] pos = map.get(call);
                marked[pos[0]][pos[1]] = true;

                // 빙고 줄 개수 세기
                if (checkBingo() >= 3) {
                    System.out.println(count);
                    done = true;
                    break;
                }
            }
            if (done) break;
        }
    }

    static int checkBingo() {
        int bingoCount = 0;

        // 가로
        for (int i = 0; i < 5; i++) {
            boolean ok = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) bingoCount++;
        }

        // 세로
        for (int j = 0; j < 5; j++) {
            boolean ok = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) bingoCount++;
        }

        // 대각선1
        boolean ok = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                ok = false;
                break;
            }
        }
        if (ok) bingoCount++;

        // 대각선2
        ok = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                ok = false;
                break;
            }
        }
        if (ok) bingoCount++;

        return bingoCount;
    }
}

