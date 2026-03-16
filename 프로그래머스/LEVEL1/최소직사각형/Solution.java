class Solution {
    public int solution(int[][] sizes) {
        // 지갑의 크기를 리턴
        int answer = 0;

        int max_w = 0;
        int max_h = 0;
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            // 작은, 큰 길이 (50, 60) 정렬 후 가장 큰거
            if (w < h) {
                max_w = Math.max(w, max_w);
                max_h = Math.max(h, max_h);
            } else {
                max_w = Math.max(h, max_w);
                max_h = Math.max(w, max_h);
            }
        }

        // System.out.println("max_w: " + max_w + ", max_h: " + max_h);
        answer = max_w * max_h;
        return answer;
    }
}