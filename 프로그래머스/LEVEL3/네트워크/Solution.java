import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int n, int[][] computers) {
        // 현재 나와 연결되어있는 노드 전부 탐색
        // 그 다음에 연결되어있는 노드를 다시 add
        // visited를 확인하면서 그 다음의 노드를 계속 add (반복)
        // 자기 자신밖에 없을때

        boolean[] nodes = new boolean[200];
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque();
        int answer = 0;
        for (int i = 0; i < computers.length; i++) {
            nodes[i] = true;
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1 && !visited[i][j] && !visited[j][i]) {
                    // 방문 기록이 없으면 탐색리스트에 추가
                    queue.add(new int[] {i, j});
                }
            }

            // 연결된 노드를 확인한다. 연결된 노드와 또 연결된 노드를 추가한다..
            if (queue.isEmpty()) {
                continue;
            }

            while (!queue.isEmpty()) {
                int[] v = queue.poll();
                int current = v[0];
                int next = v[1];
                visited[current][next] = true;

                if (!nodes[next]) {
                    nodes[next] = true;
                    for (int k = 0; k < computers[next].length; k++) {
                        if (computers[next][k] == 1 && !visited[next][k] && !visited[k][next]) {
                            queue.add(new int[] {next, k});
                        }
                    }
                }
            }
            answer++;
        }

        // System.out.println(answer);

        return answer;
    }
}