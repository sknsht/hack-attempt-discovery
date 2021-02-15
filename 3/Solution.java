import java.io.*;
import java.nio.file.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class Solution {
    private static final String LOG_FILE = "dynatrace.log";

    public static long solve() {
        final Pattern p = Pattern.compile("\\w{5}:\\w{3}:\\w{5}");
        try (Stream<String> stream = Files.lines(Paths.get(LOG_FILE))) {
            return stream
                    .map(s -> p.matcher(s).results().count())
                    .reduce(Long::sum)
                    .orElse(0L);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}