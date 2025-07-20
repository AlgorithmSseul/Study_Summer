import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 김규빈_1680 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W  = Integer.parseInt(st.nextToken()); // 쓰레기차의 용량 
			int N  = Integer.parseInt(st.nextToken()); // 지점의 개수 
			
			int sumW = 0; // 현재까지의 쓰레기의 양
			int dis = 0; // 총 거리 
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int curDis = Integer.parseInt(st.nextToken());
				int curW = Integer.parseInt(st.nextToken());
				
				if((sumW + curW) == W) { // 현재 지점까지의 쓰레기가 용량과 일치할 경우 
					dis += curDis * 2;
					sumW = 0;
				}
				else if((sumW + curW) > W){ // 현재 지점까지의 쓰레기가 용량보다 클 경우 
					dis += curDis * 2 * ((curW/W) + 1);
					sumW = curW % W;
				}
				else { // 현재 지점까지의 쓰레기가 용량보다 작을 경우 
					sumW += curW;
				}
				
				
				if(i == N - 1 && sumW != 0) dis += curDis * 2; // 마지막 지점에서 쓰레기가 남았을 경우 
			}
			
			System.out.println(dis);
		}
	}
	

}
