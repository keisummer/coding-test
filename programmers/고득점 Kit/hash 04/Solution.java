import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        List<String> sortedGenres = IntStream.range(0, genres.length)
                .boxed()
                .collect(groupingBy(i -> genres[i], summingInt(i -> plays[i])))
                .entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Map.Entry::getKey)
                .collect(toList());

        Map<String, Map<Integer, Integer>> musicMap = IntStream.range(0, genres.length).boxed()
                .collect(groupingBy(i -> genres[i], toMap(i -> i, i -> plays[i])));

        return sortedGenres.stream()
                .flatMap(g -> musicMap.get(g).entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).limit(2))
                .mapToInt(entry -> entry.getKey())
                .toArray();
    }
}
