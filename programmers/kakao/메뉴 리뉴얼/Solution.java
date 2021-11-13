import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Solution {

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < course.length; ++i) {
            List<String> setList = new ArrayList<>();

            for (int j = 0; j < orders.length; ++j) {
                char[] chars = new char[course[i]];
                combination(chars, orders[j].length(), course[i], 0, 0, orders[j].toCharArray(), setList);
            }

            Map<String, Long> CombMap = setList.stream()
                                        .collect(groupingBy(Function.identity(), counting()));

            int maxCombCount = CombMap.values()
                                .stream()
                                .mapToInt(Long::intValue)
                                .max().orElse(0);

            if (maxCombCount < 2) {
                continue;
            }

            List<String> sets = CombMap.entrySet()
                                .stream()
                                .filter(e -> e.getValue() == maxCombCount)
                                .map(Map.Entry::getKey)
                                .collect(toList());

            answer.addAll(sets);
        }

        return answer.stream().sorted(Comparator.naturalOrder()).toArray(String[]::new);
    }

    public void combination(char[] arr, int n, int r, int index, int target, char[] menus, List<String> setList) {
        if (r == 0) {
            char[] copied = Arrays.copyOf(arr, arr.length);
            Arrays.sort(copied);
            setList.add(String.valueOf(copied));
            return;
        }
        else if (target == n) {
            return;
        }

        arr[index] = menus[target];
        combination(arr, n, r - 1, index + 1,target + 1, menus, setList);
        combination(arr, n, r, index,target + 1, menus, setList);
    }
}
