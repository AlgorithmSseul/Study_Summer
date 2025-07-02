import java.io.*;
import java.util.StringTokenizer;

public class 김규빈_1780 {
    static int[][] paper;
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;
    
    static void divide(int x, int y, int size) {
        if (check(x, y, size)) {
            int val = paper[x][y];
            if (val == -1) minusOne++;
            else if (val == 0) zero++;
            else if (val == 1) one++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        int val = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != val) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

}

