package hw11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t11_04 {
    public static void main(String[] args) {
        String url = "https://time.is/Kyiv";

        String html = getHTML(url);
        String exactTimeStr = parseTime(html);

        LocalTime exactTime = LocalTime.parse(exactTimeStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime localTime = LocalTime.now();

        System.out.println("Точний час (з сайту time.is): " + exactTime);
        System.out.println("Локальний час на ноуті: " + localTime);
    }

    public static String parseTime(String html) {
        Pattern p = Pattern.compile("<time id=\"clock\">(.*?)</time>");
        Matcher m = p.matcher(html);

        if (m.find()) {
            return m.group(1).trim();
        }
        return "";
    }

    public static String getHTML(String url) {
        URI uri = URI.create(url);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(uri)
                    .GET()
                    .header("user-agent", "Hello!")
                    .build();
            HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
