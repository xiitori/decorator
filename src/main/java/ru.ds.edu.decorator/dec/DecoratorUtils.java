package ru.ds.edu.decorator.dec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecoratorUtils {
    public static String snakeCaseMessage(String message) {
        Pattern pattern = Pattern.compile("\\.([A-Z].*)@");
        Matcher matcher = pattern.matcher(message);

        if (!matcher.find()) {
            return message;
        }

        String className = matcher.group(1);
        StringBuilder sb = new StringBuilder(className);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);

                if (i != 0) {
                    sb.replace(i, i + 1, "_" + ch);
                } else {
                    sb.setCharAt(i, ch);
                }
            }
        }

        message = message.replace(className, sb.toString());
        return message;
    }
}
