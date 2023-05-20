package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Student student1 = new Student("Burlaka", "Olexander", "Bura", Sex.MALE);
        Student student2 = new Student("Vitaliy", "Volochay", "12312", Sex.FEMALE);
        Group group1 = new Group("122-20-2", student1);
        Group group2 = new Group("135-18-1", student2);
        Department department1 = new Department("Department 1", group1);
        Department department2 = new Department("Department 2", group2);
        Faculty faculty1 = new Faculty("FIT", department1);
        Faculty faculty2 = new Faculty("FIT", department2);
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty1);
        faculties.add(faculty2);
        University oldUniversity = new University("NTU DP", faculties);

        writeUniversityToJsonFile(oldUniversity, "university.json");

        University newUniversity = readUniversityFromJsonFile("university.json");

        System.out.println("Are oldUniversity and newUniversity equal? " + oldUniversity.equals(newUniversity));

        String json = "{\"name\":\"NTU DP\",\"faculties\"" +
                ":[{\"name\":\"FIT\",\"department\"" +
                ":{\"name\":\"FIT\",\"group\":" +
                "{\"name\":\"122-20-2\",\"student\"" +
                ":{\"name\":\"John\",\"surname\":\"Doe\",\"patronymic\":\"Smith\",\"sex\":\"MALE\"}}}}]}";
        University universityFromJson = createUniversityFromJson(json);
        System.out.println("Created university from JSON: " + universityFromJson.getName());
    }

    private static void writeUniversityToJsonFile(University university, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static University readUniversityFromJsonFile(String fileName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static University createUniversityFromJson(String json) {
        Gson gson = new Gson();
        Type universityType = new TypeToken<University>() {}.getType();
        return gson.fromJson(json, universityType);
    }
    }

