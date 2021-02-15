import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    private static final String LOG_FILE = "dynatrace.log";
    private static final List<String> OFFENDING = List.of("57.48.9.100", "2.21.107.254", "130.25.179.252");

    public static List<String> solve() {
        final Map<String, Integer> occurrences = new HashMap<>();
        final Pattern p = Pattern.compile("clientIp=[^\\s]*");

        try (Stream<String> stream = Files.lines(Paths.get(LOG_FILE))) {
            stream.filter(Solution::isSuccessfulLogin).forEach(s -> {
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

        return OFFENDING.stream()
                .map(ip -> String.format("%d successful logins from that %s", occurrences.getOrDefault(ip, 0), ip))
                .collect(Collectors.toList());
    }

    private static boolean isSuccessfulLogin(String log) {
        final Map<String, String> successfulParams = Map.of(
                "httpMethod", "POST",
                "requestUrl", "/dynatrace.com/login",
                "statusCode", "200"
        );
        return successfulParams.keySet().stream()
                .allMatch(key -> log.contains(String.format("%s=%s", key, successfulParams.get(key))));
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}