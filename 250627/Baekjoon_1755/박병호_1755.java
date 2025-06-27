package Baekjoon_1755;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 박병호_1755 {  //메모리 14320kb  시간 116ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        //숫자를 해당 인덱스에 맞춰서 변환해 줄 수 있게 배열을 생성
        String[] abc123 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        //정렬을 시켜줄  Map 생성   *굳이 Map을 안써도 상관없을 듯 하고 어떤 거 쓰냐에 따라 메모리 차이가 날 수도 있을 것 같다*
        Map<String, Integer> sortABC123 = new HashMap<>();

        //정렬 해줄 값의 범위를 입력 받는다.
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //범위의 숫자를 문자열로 전환 해서 Map에 저장
        for (int i = start; i <= end; i++) {
            if (i >= 10) {   //두 자리일 경우는 숫자를 절단해 하나씩 저장 +문제에 입력 범위가 99까지
                int firstNum = i / 10;
                int secondNum = i % 10;
                String word = abc123[firstNum] + abc123[secondNum];  //해당하는 인덱스에 알맞은 문자를 가져와서 변환 후 합체

                sortABC123.put(word, i);   //맵에 문자열을 키 값으로 숫자를  밸류로 저장
            } else {
                String word = abc123[i];  //한자리의 경우 바로 저장

                sortABC123.put(word, i);
            }
        }
        List<String> keySet = new ArrayList<>(sortABC123.keySet());  //Map의 값들을 키 값 기준으로 정렬
        Collections.sort(keySet);

        int count = 0;
        for (String key : keySet) {  //한 줄에 10씩 출력해야 하기에 때문에 10번마다 개행 해준다.
            System.out.print(sortABC123.get(key) + " ");
            count++;
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }
}
