import java.io.*;
import java.util.*;

public class 김규빈_2599 {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] male = new int[3];
        int[] female = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            male[i] = Integer.parseInt(st.nextToken());
            female[i] = Integer.parseInt(st.nextToken());
        }

        int[][] pair = new int[3][3];

        // A남 → B여, C여
        pair[0][1] = Math.min(male[0], female[1]);
        male[0] -= pair[0][1];
        female[1] -= pair[0][1];

        pair[0][2] = Math.min(male[0], female[2]);
        male[0] -= pair[0][2];
        female[2] -= pair[0][2];

        // B남 → A여, C여
        pair[1][0] = Math.min(male[1], female[0]);
        male[1] -= pair[1][0];
        female[0] -= pair[1][0];

        pair[1][2] = Math.min(male[1], female[2]);
        male[1] -= pair[1][2];
        female[2] -= pair[1][2];

        // C남 → A여, B여
        pair[2][0] = Math.min(male[2], female[0]);
        male[2] -= pair[2][0];
        female[0] -= pair[2][0];

        pair[2][1] = Math.min(male[2], female[1]);
        male[2] -= pair[2][1];
        female[1] -= pair[2][1];

        // 조건 검사!
        if (male[0] > 0 || male[1] > 0 || male[2] > 0 ||
            female[0] > 0 || female[1] > 0 || female[2] > 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
            System.out.println(pair[0][1] + " " + pair[0][2]);
            System.out.println(pair[1][0] + " " + pair[1][2]);
            System.out.println(pair[2][0] + " " + pair[2][1]);
        }
    }
}
