import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int maxPick = nums.length / 2;

        HashSet<Integer> pokemonTypes = new HashSet<>();
        for (int num : nums) {
            pokemonTypes.add(num);
        }

        int typeCount = pokemonTypes.size();

        return Math.min(typeCount, maxPick);
    }
}