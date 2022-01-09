import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = new int[rows + 1][columns + 1];

        int number = 1;
        for (int row = 1; row <= rows; ++row) {
            for (int col = 1; col <= columns; ++col) {
                map[row][col] = number;
                number += 1;
            }
        }

        for (int i = 0; i < queries.length; ++i) {
            answer[i] = rotateAndFindMinValue(map, queries[i]);
        }

        return answer;
    }

    private Integer rotateAndFindMinValue(int[][] map, int[] query) {
        List<Integer> result = new ArrayList<>();

        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int startValue = map[x1][y1];
        result.add(startValue);

        for (int x = x1; x < x2; ++x) {
            map[x][y1] = map[x + 1][y1];
            result.add(map[x][y1]);
        }

        for (int y = y1; y < y2; ++y) {
            map[x2][y] = map[x2][y + 1];
            result.add(map[x2][y]);
        }

        for (int x = x2; x > x1; --x) {
            map[x][y2] = map[x - 1][y2];
            result.add(map[x][y2]);
        }

        for (int y = y2; y > y1; --y) {
            map[x1][y] = map[x1][y - 1];
            result.add(map[x1][y]);
        }

        map[x1][y1 + 1] = startValue;

        return Collections.min(result);
    }
}
