// 메모리: 72.2 MB, 시간: 5.48 ms

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        List<Integer> server = new ArrayList<Integer>();
        
        for(int i = 0; i < 24; i++){
            int num = players[i];
            int plus_server = num / m;
            
            //서버 시간 1씩 깎기
            if(server.size() != 0){
                server.replaceAll(x -> x - 1);
            }
            
            //0인 서버 삭제
            server.removeIf(x -> x.equals(0));
            
            //현재 증설된 서버의 수가 게임 이용자 수를 감당하지 못한다면
            if(plus_server > server.size()){
                int plus_cnt = plus_server - server.size();
                //서버 증설하기
                for(int j = 0; j < plus_cnt; j++){
                    server.add(k);
                    answer++;
                }
            }
            
        }
        
        return answer;
    }
}