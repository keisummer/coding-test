import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> o2.concat(o1).compareTo(o1.concat(o2)))
                .collect(Collectors.joining());

        return result.charAt(0) == '0' ? "0" : result;
    }
}
