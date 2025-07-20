import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());    //근데 아직도 이걸로 받아야되는지 모르겠음

        BigInteger result = N.add(N).subtract(BigInteger.valueOf(2));

        if (N.equals(BigInteger.ONE))
            result = BigInteger.ONE;

        System.out.println(result);
    }
}


//이거 첨에 백트래킹을 풀다가,,,런타임에러, 컴파일에러 뜸,,
//이거 설명 좀 해주세여,,