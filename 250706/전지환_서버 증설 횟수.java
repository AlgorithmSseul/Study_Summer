/*
 * 성능 요약
 * 메모리: 78.7 MB, 시간: 0.08 ms
*/

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {     
        // players : 시간대별 이용자 수
        // m : 서버 한 대로 감당 가능한 최대 이용자 수
        // k : 서버 한 대가 운영 가능한 시간
        int answer = 0; // 총 증설 횟수
        int now = 0; // 현재 서버 수
        int count[] = new int[24]; // 해당 시간대 증설 횟수
        
        for (int i = 0; i < 24; i++){
            while (i-k >= 0 && count[i-k] > 0) {
                count[i-k]--;
                now--;
            }
            while (((now+1) * m) - 1 < players[i]) {
                now++;
                answer++;
                count[i]++;
            }
            
        }
        
        return answer;
    }
}