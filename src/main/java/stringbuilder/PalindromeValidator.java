package stringbuilder;

public class PalindromeValidator {
    public boolean isPalidrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null!");
        }

        text = text.trim();

        StringBuilder sb = new StringBuilder(text);
        return text.equalsIgnoreCase(sb.reverse().toString());
    }
}
