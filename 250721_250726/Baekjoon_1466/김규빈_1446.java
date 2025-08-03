import java.io.*;
import java.util.*;

public class 김규빈_1446 {

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길 수
        int D = Integer.parseInt(st.nextToken()); // 고속도로 길이

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        // 기본 고속도로: i → i+1에 비용 1
        for (int i = 0; i < D; i++) {
            graph.get(i).add(new Edge(i + 1, 1));
        }

        // 지름길 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (end > D || end - start <= length) continue; // 유효하지 않은 지름길 무시
            graph.get(start).add(new Edge(end, length));
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (dist[cur.to] < cur.weight) continue;

            for (Edge next : graph.get(cur.to)) {
                if (dist[next.to] > dist[cur.to] + next.weight) {
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        System.out.println(dist[D]);
    }
}
