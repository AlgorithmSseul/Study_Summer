import java.io.*;
import java.util.*;

public class 김규빈_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> horizontalCuts = new ArrayList<>();
        List<Integer> verticalCuts = new ArrayList<>();
        
        // 종이 경계 포함
        horizontalCuts.add(0);
        horizontalCuts.add(h);
        verticalCuts.add(0);
        verticalCuts.add(w);
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            if (dir == 0) {
                horizontalCuts.add(num);
            } else {
                verticalCuts.add(num);
            }
        }
        
        // 정렬
        Collections.sort(horizontalCuts);
        Collections.sort(verticalCuts);
        
        // 최대 간격 찾기
        int maxHeight = 0;
        for (int i = 1; i < horizontalCuts.size(); i++) {
            int gap = horizontalCuts.get(i) - horizontalCuts.get(i - 1);
            maxHeight = Math.max(maxHeight, gap);
        }
        
        int maxWidth = 0;
        for (int i = 1; i < verticalCuts.size(); i++) {
            int gap = verticalCuts.get(i) - verticalCuts.get(i - 1);
            maxWidth = Math.max(maxWidth, gap);
        }
        
        System.out.println(maxHeight * maxWidth);
    }
}
