import java.util.*;

class Solution {
    // 사용자 정보 [최소 할인율, 구매 한도]
    static int[][] users;

    // 이모티콘 정가 배열
    static int[] emoticons;

    // 할인율 적용된 이모티콘 가격 [이모티콘 인덱스][할인율 인덱스]
    static int[][] discountedPrices;

    // 할인율 (10%, 20%, 30%, 40%)
    static int[] discountRates = {10, 20, 30, 40};

    // 현재 DFS에서 선택된 각 이모티콘의 할인율 인덱스
    static int[] selectedRates;

    // 최대 이모티콘 플러스 가입자 수
    static int maxPlus = 0;

    // 최대 이모티콘 판매 금액
    static int maxSales = 0;

    public int[] solution(int[][] inputUsers, int[] inputEmoticons) {
        users = inputUsers;
        emoticons = inputEmoticons;
        selectedRates = new int[emoticons.length];

        // 할인율별 이모티콘 가격을 미리 계산해 저장
        discountedPrices = new int[emoticons.length][4]; // 4: 10%, 20%, 30%, 40%
        for (int i = 0; i < emoticons.length; i++) {
            for (int j = 0; j < 4; j++) {
                discountedPrices[i][j] = emoticons[i] * (100 - discountRates[j]) / 100;
            }
        }

        // 이모티콘마다 할인율 조합을 DFS로 탐색
        dfs(0);

        // 최종 결과: [이모티콘 플러스 가입자 수, 이모티콘 매출 총액]
        return new int[]{maxPlus, maxSales};
    }

    // 각 이모티콘에 할인율을 선택해보는 DFS
    static void dfs(int depth) {
        if (depth == emoticons.length) {
            evaluate(); // 현재 할인율 조합에 대해 평가
            return;
        }

        // 10%, 20%, 30%, 40% 중 하나를 선택
        for (int i = 0; i < 4; i++) {
            selectedRates[depth] = i;
            dfs(depth + 1);
        }
    }

    // 현재 할인율 조합(selectedRates)을 기준으로 사용자 반응을 평가
    static void evaluate() {
        int plusCount = 0;  // 이모티콘 플러스 가입자 수
        int totalSales = 0; // 이모티콘 판매 총액

        for (int[] user : users) {
            int minDiscount = user[0];       // 사용자가 원하는 최소 할인율
            int priceThreshold = user[1];    // 사용자의 이모티콘 구매 한도
            int userPurchase = 0;            // 현재 사용자의 구매 총액

            // 각 이모티콘에 대해 사용자 조건에 따라 구매 여부 판단
            for (int i = 0; i < emoticons.length; i++) {
                int rateIdx = selectedRates[i];           // 현재 이모티콘의 할인율 인덱스
                int appliedDiscount = discountRates[rateIdx]; // 실제 할인율

                // 사용자의 최소 할인율 조건을 만족할 경우 구매함
                if (appliedDiscount >= minDiscount) {
                    userPurchase += discountedPrices[i][rateIdx];
                }
            }

            // 구매 총액이 사용자 기준 초과, 이모티콘 플러스 가입
            if (userPurchase >= priceThreshold) {
                plusCount++;
            } else {
                // 그렇지 않으면 그냥 이모티콘 매출로 계산
                totalSales += userPurchase;
            }
        }

        // 최대 가입자 수 갱신 (동점일 경우 매출이 더 큰 쪽 선택)
        if (plusCount > maxPlus) {
            maxPlus = plusCount;
            maxSales = totalSales;
        } else if (plusCount == maxPlus && totalSales > maxSales) {
            maxSales = totalSales;
        }
    }
}
