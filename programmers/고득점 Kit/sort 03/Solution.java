import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Solution {
    public int solution(int[] citations) {
        List<Integer> sortedCitations = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(toList());

        if (sortedCitations.get(0) == 0) {
            return 0;
        }

        return IntStream.rangeClosed(1, citations.length)
                .filter(i -> {
                    return i == citations.length ||
                            i == sortedCitations.get(i - 1) ||
                            i >= sortedCitations.get(i);
                })
                .findFirst()
                .getAsInt();
    }
}
