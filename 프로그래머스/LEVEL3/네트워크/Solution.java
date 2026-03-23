import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 노드 방문 여부

        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터라면 새로운 네트워크의 시작점
            if (!visited[i]) {
                bfs(i, n, computers, visited);
                answer++; // 네트워크 개수 증가
            }
        }

        return answer;
    }

    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;  // 현재 노드 방문

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next = 0; next < n; next++) {
                // 연결되어 있고, 아직 방문하지 않은 컴퓨터라면
                if (computers[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}