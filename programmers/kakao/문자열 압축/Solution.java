class Solution {
    public int solution(String s) {
        int min = 1000;

        for (int i = 1; i <= (s.length() + 1) / 2; ++i) {
            int answer = compress(s, s.substring(0, i), 0, 0);
            if (answer < min) {
                min = answer;
            }
        }

        return min;
    }

    private int compress(String remainString, String token, int total, int matchCount) {
        if (!remainString.isEmpty() && remainString.length() >= token.length()) {
            if (remainString.startsWith(token)) {
                return compress(remainString.substring(token.length()), token, total, ++matchCount);
            }

            total += sum(token.length(), matchCount);
            return compress(remainString, remainString.substring(0, token.length()), total, 0);
        }

        total += sum(token.length(), matchCount);
        return total + remainString.length();
    }

    private int sum(int tokenSize, int matchCount) {
        if (matchCount > 1) {
            return String.valueOf(matchCount).length() + tokenSize;
        }
        return tokenSize;
    }
}