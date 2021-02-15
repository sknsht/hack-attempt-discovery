import java.io.*;
import java.nio.file.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
	private static final String LOG_FILE = "dynatrace.log";
    private static final Set<String> OFFENDING = Set.of("57.48.9.100", "2.21.107.254", "130.25.179.252");

    public static String solve() {
        final Map<String, Integer> occurrences = new HashMap<>();
        final Pattern p = Pattern.compile("clientIp=[^\\s]*");

        try (Stream<String> stream = Files.lines(Paths.get(LOG_FILE))) {
            stream.forEach(s -> {
                final Matcher m = p.matcher(s);
                while (m.find()) {
                    final String ip = m.group().split("=")[1];
                    if (OFFENDING.contains(ip))
                        occurrences.put(ip, occurrences.getOrDefault(ip, 0) + 1);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return occurrences.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(e -> String.format("%s=%d", e.getKey(), e.getValue()))
                .collect(Collectors.joining(", ", "{", "}"));
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}