package hw11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t11_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Введіть назву міста (in English): ");
        String city = in.next();
        
        String site = "https://www.meteoprog.com/ua/weather/";
        String url = site + city + "/";
        String html = getHTML(url);
        parseAndPrintForecast(html);
    }

    public static void parseAndPrintForecast(String html) {
        Pattern dayPattern = Pattern.compile("<div class=\"thumbnail-item__title\">(.*?)</div>", Pattern.DOTALL);
        Matcher dayMatcher = dayPattern.matcher(html);

        Pattern tmaxPattern = Pattern.compile("<div class=\"temperature-max\">(.*?)</div>", Pattern.DOTALL);
        Matcher tmaxMatcher = tmaxPattern.matcher(html);

        Pattern tminPattern = Pattern.compile("<div class=\"temperature-min\">(.*?)</div>", Pattern.DOTALL);
        Matcher tminMatcher = tminPattern.matcher(html);

        int count = 0;
        while (dayMatcher.find() && tmaxMatcher.find() && tminMatcher.find() && count < 4) {
            String day = dayMatcher.group(1).replaceAll("<.*?>", "").trim();
            String tmax = tmaxMatcher.group(1).replaceAll("<.*?>", "").trim();
            String tmin = tminMatcher.group(1).replaceAll("<.*?>", "").trim();

            System.out.println(day + " — Max: " + tmax + ", Min: " + tmin);
            count++;
        }
    }

    public static String getHTML(String url) {
        URI uri = URI.create(url);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(uri)
                    .GET()
                    .header("User-Agent", "Hello!")
                    .build();
            HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}