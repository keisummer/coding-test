import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> clothesMap = Stream.of(clothes)
                                                .collect(toMap(
                                                        c -> c[1],
                                                        c -> {
                                                            List<String> result = new ArrayList<>();
                                                            result.add(c[0]);
                                                            return result;
                                                        },
                                                        (o, n) -> { o.addAll(n); return o;}));

        int answer = 1;
        for (String kind : clothesMap.keySet()) {
            // (a+1)(b+1)(c+1)...
            answer *= clothesMap.get(kind).size() + 1;
        }

        // 아무것도 선택하지 않는 경우 제외
        return answer - 1;
    }
}