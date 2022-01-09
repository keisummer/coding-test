import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        Map<Integer, Integer> standingMap = new HashMap<>();
        standingMap.put(6, 1);
        standingMap.put(5, 2);
        standingMap.put(4, 3);
        standingMap.put(3, 4);
        standingMap.put(2, 5);

        int zeroCount = 0;
        int equalCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }

            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    equalCount++;
                    continue;
                }
            }
        }

        int[] answer = {
                standingMap.containsKey(equalCount + zeroCount) ? standingMap.get(equalCount + zeroCount) : 6,
                standingMap.containsKey(equalCount) ? standingMap.get(equalCount) : 6
        };

        return answer;
    }
}
