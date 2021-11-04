import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> participantMap = Arrays.stream(participant).collect(groupingBy(Function.identity(), counting()));
        Arrays.stream(completion).forEach(c -> participantMap.compute(c, (k, v) -> (v == null) ? -1 : v - 1));

        return participantMap.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(toList())
                .get(0);
    }
}