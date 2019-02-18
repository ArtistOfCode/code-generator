package cn.codeartist.code.generator.utils;

import java.util.function.Consumer;

/**
 * @author 艾江南
 * @date 2019/1/31
 */
public class FunctionUtil {

    public static void requireNonEmpty(String str, Consumer<String> consumer) {
        if (str != null && !str.trim().isEmpty()) {
            consumer.accept(str);
        }
    }

    public static void requireNonEmptyThrow(String str, Consumer<String> consumer) {
        requireNonEmptyThrow(str, consumer, "the string is empty");
    }

    public static void requireNonEmptyThrow(String str, Consumer<String> consumer, String message) {
        if (str != null && !str.trim().isEmpty()) {
            consumer.accept(str);
        } else {
            throw new NullPointerException(message);
        }
    }

}
