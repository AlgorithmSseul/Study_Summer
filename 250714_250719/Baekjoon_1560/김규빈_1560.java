import java.io.*;
import java.math.BigInteger;

public class 김규빈_1560 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        BigInteger N = new BigInteger(s);

        BigInteger result;
        if (N.equals(BigInteger.ONE)) {
            result = BigInteger.ONE;
        } else {
            result = N.multiply(BigInteger.valueOf(2))
                      .subtract(BigInteger.valueOf(2));
        }

        System.out.println(result);
    }
}
