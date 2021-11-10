import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(c -> {
                    return IntStream.range(c[0] - 1, c[1])
                            .map(i -> array[i])
                            .sorted()
                            .boxed()
                            .collect(Collectors.toList())
                            .get(c[2] - 1);
                }).toArray();
    }
}