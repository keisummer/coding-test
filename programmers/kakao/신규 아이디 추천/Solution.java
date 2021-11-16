import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final String MATCH_REGEX_1 = "[~!@#$%^&*()=+\\[\\{\\]\\}:?,<>]*";
    private static final String MATCH_REGEX_2 = "[\\.]{2,}";
    private static final String COMMA_STRING = ".";
    private static final String EMPTY_STRING = "";

    public String solution(String new_id) {
        //1
        new_id = new_id.toLowerCase();

        new_id.replaceAll(MATCH_REGEX_1, "");
        //2
        Pattern pattern = Pattern.compile(MATCH_REGEX_1);
        Matcher matcher = pattern.matcher(new_id);
        new_id = matcher.replaceAll(EMPTY_STRING);

        //3
        pattern = Pattern.compile(MATCH_REGEX_2);
        matcher = pattern.matcher(new_id);
        new_id = matcher.replaceAll(COMMA_STRING);

        //4
        new_id = new_id.startsWith(COMMA_STRING) ? new_id.replaceFirst(COMMA_STRING, EMPTY_STRING) : new_id;
        new_id = new_id.endsWith(COMMA_STRING) ? new_id.substring(0, new_id.lastIndexOf(COMMA_STRING)) :new_id;

        //5
        new_id = new_id.isEmpty() ? "a" : new_id;

        //6
        new_id = new_id.length() > 15 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.endsWith(COMMA_STRING) ? new_id.substring(0, 14) : new_id;

        //7
        new_id = new_id.length() < 3 ? new_id.concat(new_id.substring(new_id.length() - 1).repeat(3 - new_id.length())) : new_id;

        return new_id;
    }
}
