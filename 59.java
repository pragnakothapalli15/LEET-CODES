class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;

        // Store numbers and factorials
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact[i] = fact[i - 1] * i;
        }

        k--; // Convert to 0-based index
        StringBuilder ans = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            ans.append(numbers.get(index));
            numbers.remove(index);
            k %= fact[i - 1];
        }

        return ans.toString();
    }
}
