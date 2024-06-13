package org.data;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
   private static String weatherKeyPath = "data/src/main/resources/weatherKey.txt";

    private static String getWeatherKey() throws IOException {
        Path path = Paths.get(weatherKeyPath).normalize();
        return new String(Files.readAllBytes(path)).trim();
    }
    public static String getWeatherData() throws IOException {
        String apiKey = getWeatherKey();
        String apiUrl = String.format("https://api.weatherapi.com/v1/forecast.json?key=%s&q=Kyiv&days=3", apiKey);
        return Request.Get(apiUrl).execute().returnContent().asString();

  }

    public static void main(String[] args) throws IOException {
        System.out.println(getWeatherKey());
        System.out.println(getWeatherData());
    }

}