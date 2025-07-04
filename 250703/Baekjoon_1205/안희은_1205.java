import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력: rankingCount = 기존 랭킹 수, newScore = 새로운 점수, maxRankingSize = 랭킹 최대 인원 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rankingCount = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int maxRankingSize = Integer.parseInt(st.nextToken());

		List<Integer> scoreList = new ArrayList<>();

		// 기존 랭킹이 없다면 무조건 1등
		if (rankingCount == 0) {
			System.out.println(1);
			return;
		}

		// 기존 점수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < rankingCount; i++) {
			scoreList.add(Integer.parseInt(st.nextToken()));
		}

		// 내림차순 정렬
		scoreList.sort(Comparator.reverseOrder());

		// 새로운 점수가 들어갈 등수 찾기(무조건 새로운 점수가 클 때, 기존 점수보다 작거나 같아지면 등수 저장)
		int rank = 1;
		for (int i = 0; i < scoreList.size(); i++) {
			if (newScore >= scoreList.get(i)) {
				break;
			}
			rank++;
		}

		// 랭킹 꽉 찼고 마지막 등수보다 점수 낮거나 같음
		if (rankingCount == maxRankingSize && newScore <= scoreList.get(scoreList.size() - 1)) {
			System.out.println(-1);
			return;
		} else {
			System.out.println(rank);
		}
	}
}

// 풀이방법
/*
 * 기존 점수 내림차순 정렬(scoreList.sort(Comparator.reverseOrder()), 내림차순 정렬 방법 암기하기)
 * 바보 이슈 여러번 함...(새로운 점수가 기존 점수보다 작거나 같아지면 등수 저장)
 * 입력 조건 있는 문제는 처음이었음!(실행 끝내고 싶으면 return을 하면 됨)
 */
