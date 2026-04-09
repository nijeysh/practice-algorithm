class Solution {
    private int max = 0;
    private boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        find(0, k, dungeons);

        return max;
    }

    private void find(int depth, int k, int[][] dungeons) {
        // 현재까지 탐험한 던전 수가 최대값보다 크면 갱신
        if (depth > max) {
            max = depth;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                find(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}