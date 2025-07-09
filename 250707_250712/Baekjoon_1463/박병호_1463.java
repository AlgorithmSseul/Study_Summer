package Baekjoon_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박병호_1463 { //18312kb 128ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[1000001]; //범위를 입력값의 범위까지
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 1;  //초반 값을 미리 입력
        int num = Integer.parseInt(br.readLine());
        for (int i = 4; i <= num; i++) { //4부터 차례대로 다이나믹 프로그래밍으로 답을 구한다
            if (i % 6 == 0) {  //3이나 2로 나누어질 경우 3이나 2로 나눈 값의 최솟값에 +1을 한 값이 것이다.
                int minNum = Math.min(nums[i / 3] + 1, nums[i / 2] + 1);
                nums[i] = minNum; //dp를 위해 값 저장
            } else if (i % 3 == 0) { //3으로 나누어지는 값의 경우 3으로 나눈 값의 최솟값+1 , 그리고 이전 값에 +1 ,이이전값에 +2 한 횟수중 최솟값이 있을 것이다.
                int minNum = Math.min(nums[i - 1] + 1, nums[i - 2] + 2);
                nums[i] = Math.min(nums[i / 3] + 1, minNum);
            } else if (i % 2 == 0) {//2로 나누어지는 값도 마찬가지
                int minNum = Math.min(nums[i - 1] + 1, nums[i - 2] + 2);
                nums[i] = Math.min(nums[i / 2] + 1, minNum);
            } else { //둘 다 안나누어 지는 값이라면 이전값+1 이이전값 +2 둘중 하나가 정답
                nums[i] = Math.min(nums[i - 1] + 1, nums[i - 2] + 2);
            }
        }
        sb.append(nums[num]);
        System.out.println(sb);
    }
}


