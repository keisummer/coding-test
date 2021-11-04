import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public boolean solution(String[] phone_book) {

        List<String> sortedPhoneBook = Arrays.stream(phone_book)
                                    .sorted(String::compareTo)
                                    .collect(Collectors.toList());

        boolean match = IntStream.range(0, sortedPhoneBook.size() - 1)
                        .anyMatch(i -> sortedPhoneBook.get(i + 1).startsWith(sortedPhoneBook.get(i)));

        return !match;
    }
}