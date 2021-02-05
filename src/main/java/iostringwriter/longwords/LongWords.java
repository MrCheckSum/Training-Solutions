package iostringwriter.longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class LongWords {

    public void writeLongWords(Writer writer, List<String> words) {
        PrintWriter pw = new PrintWriter(writer);
        for (String item : words) {
            pw.print(item);
            pw.print("=");
            pw.print(item.length());
            pw.print("\n");
        }
    }

    public String stringWriteLongWords(List<String> words) {
        try (StringWriter sw = new StringWriter()) {
            writeLongWords(sw, words);
            return sw.toString();
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-writeable!", ioException);
        }
    }

    public static void main(String[] args) {
        LongWords longWords = new LongWords();
        List<String> words = List.of("Megszentsegtelenithetetlensegeskedeseitekert", "rezfanfuttyulorezangyal");

        System.out.println(longWords.stringWriteLongWords(words));

    }
}
