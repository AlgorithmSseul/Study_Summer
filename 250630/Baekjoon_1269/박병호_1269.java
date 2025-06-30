package Baekjoon_1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 박병호_1269 { //메모리 67084KB 시간584ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());  //A집합과 B집합의 사이지 입력
        int bSize = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> a = new HashMap<>();

        StringTokenizer aNum = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {  //A집합의 값을 Map에 put해준다.
            int key = Integer.parseInt(aNum.nextToken());
            a.put(key, 0);
        }
        StringTokenizer bNum = new StringTokenizer(br.readLine());
        int onlyBCnt = 0;
        for (int i = 0; i < bSize; i++) {  //해당 문제는 차집합의 개수를 구하는 문제이기에 b집합의 값을 저장하지 않고 바로 비교
            int b = Integer.parseInt(bNum.nextToken());
            if (a.containsKey(b)) {  //b집합의 값이 A에 있다면 map에서 제거
                a.remove(b);
            } else {
                onlyBCnt++;   //아니라면 B의 차집합이므로 카운트
            }
        }

        int answer = a.size() + onlyBCnt;  //b의 값이 제거된 map의 size = A의 차집합 + 위에서 카운트한 B의 차집합 개수
        System.out.println(answer);
    }
}
