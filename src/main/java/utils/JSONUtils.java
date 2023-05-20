package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.University;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JSONUtils {
    public static void writeUniversityToJsonFile(University university, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static University readUniversityFromJsonFile(String filePath) {
        Gson gson = new Gson();

        try {
            String json = Files.readString(Path.of(filePath));
            return gson.fromJson(json, University.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}