package Baekjoon_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 박병호_1316 { //14172kb  104ms
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        char now=' ';
        int answer=0;  //정답 개수 카운트
        for (int i = 0; i < N; i++) {
            List<Character> abcdefg=new ArrayList<>();
            String word=br.readLine();
            now=word.charAt(0);  //단어의 첫글자 저장
            abcdefg.add(now);   //리스트에도 저장
            boolean tf=true;    //정답 유무 판별
            for (int j = 1; j <word.length() ; j++) {
                if(now!=word.charAt(j)){  //만약의 현재 글자와 다음 글자가 다를 경우
                    if(abcdefg.contains(word.charAt(j))){  //이미 나왔던 문제라면 false처리 후 탈출
                        tf=false;
                        break;
                    }else{  //아니라면 리스트에 추가후 반복문 계속 진행
                        now=word.charAt(j);
                        abcdefg.add(word.charAt(j));
                    }
                }
            }
            if(tf){  //반복문 후에도 참이면 정답 카운트
                answer++;
            }
        }
        System.out.println(answer);
    }
}
