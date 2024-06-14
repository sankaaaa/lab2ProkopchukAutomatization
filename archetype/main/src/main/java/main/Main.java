package main;

import data.Data;
import text.Text;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Text.renderWeatherText(Data.getWeatherData());
    }
}