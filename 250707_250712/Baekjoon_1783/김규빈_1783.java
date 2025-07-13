import java.io.*;
import java.util.StringTokenizer;

public class 김규빈_1783{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long result;
        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) {
                result = Math.min(4, M);
            } else {
                result = M - 2;
            }
        }

        System.out.println(result);
    }
}
