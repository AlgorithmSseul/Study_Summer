/*
 * 성능 요약
 * 메모리: 86.8 MB, 시간: 1.15 ms
*/
class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int tired = 0;
        int num = 0;
        dfs(picks, minerals, tired, num);
        
        
        return answer;
    }
    
    static void dfs(int[] picks, String[] minerals, int tired, int num) {
        if (tired >= answer) {
            return;
        }
        
        if ((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || num == minerals.length) {
            answer = Math.min(answer, tired);
            return;
        }
        
        if (picks[0] > 0){
            picks[0]--;
            int count = 0;
            while (count < 5 && num < minerals.length){
                tired++;
                num++;
                count++;
            }
            dfs(picks, minerals, tired, num);
            picks[0]++;
            while (count > 0){
                tired--;
                num--;
                count--;
            }
        }
        if (picks[1] > 0){
            picks[1]--;
            int count = 0;
            while(count < 5 && num < minerals.length){
                if (minerals[num].equals("diamond")) {
                    tired += 5;
                } else {
                    tired += 1;
                }
                num++;
                count++;
            }
            dfs(picks, minerals, tired, num);
            picks[1]++;
            while(count > 0){
                num--;
                if (minerals[num].equals("diamond")) {
                    tired -= 5;
                } else {
                    tired -= 1;
                }
                count--;
            }
        }
        if (picks[2] > 0){
            picks[2]--;
            int count = 0;
            while(count < 5 && num < minerals.length){
                if (minerals[num].equals("diamond")) {
                    tired += 25;
                } else if (minerals[num].equals("iron")) {
                    tired += 5;
                } else {
                    tired += 1;
                }
                num++;
                count++;
            }
            dfs(picks, minerals, tired, num);
            picks[2]++;
            while(count > 0){
                num--;
                if (minerals[num].equals("diamond")) {
                    tired += 25;
                } else if (minerals[num].equals("iron")) {
                    tired += 5;
                } else {
                    tired += 1;
                }
                count--;
            }
        }
    }
}