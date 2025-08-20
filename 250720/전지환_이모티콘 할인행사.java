/*
 * 성능 요약
 * 메모리: 96.6 MB, 시간: 68.74 ms
*/
class Solution {
    static int[] sales = {40,30,20,10};
    static int[] sel;
    static boolean[] visited;
    static boolean[] plusUser;
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        sel = new int[emoticons.length];
        visited = new boolean[emoticons.length];
        
        dfs(users, emoticons, 0);
        
        
        return answer;
    }
    
    public void dfs(int[][] users, int[] emoticons, int count) {
        if (count == emoticons.length){
            int[] curEmo = new int[users.length];
            plusUser = new boolean[users.length];
            clac(users, emoticons, 0, curEmo, 0);
            return;
        }
        
          if (!visited[count]){
              for (int j = 0; j < 4; j++){
                  sel[count] = sales[j];
                  visited[count] = true;
                  dfs(users, emoticons, count + 1);
                  visited[count] = false;
             }    
          }
        
    }
    
    public void clac(int[][] users, int[] emoticons, int curPlus, int[] curEmo, int count){
        if (count == emoticons.length){
            boolean flag1 = false;
            boolean flag2 = false;
            if (curPlus > answer[0]){
                answer[0] = curPlus;
                flag1 = true;
            } else if (curPlus == answer[0]){
                flag2 = true;
            }
            int totalEmo = 0;
            for (int i = 0; i < curEmo.length; i++){
                totalEmo += curEmo[i];
            }
            if (flag1){
                answer[1] = totalEmo;
            } else if (flag2 && totalEmo > answer[1]){
                answer[1] = totalEmo;
            }
            return;
        }
        
        for (int i = 0; i < users.length; i++){
            if (!plusUser[i]) {
                if (users[i][0] <= sel[count]) {
                    curEmo[i] += (emoticons[count] / 100) * (100 - sel[count]);
                    if (curEmo[i] >= users[i][1]){
                        curEmo[i] = 0;
                        curPlus++;
                        plusUser[i] = true;
                    }
                }
            }
        }
        
        clac(users, emoticons, curPlus, curEmo, count + 1);
    }
}