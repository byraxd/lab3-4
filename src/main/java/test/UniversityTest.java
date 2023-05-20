package test;

import controller.UniversityController;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.JSONUtils;

import java.util.Collections;

public class UniversityTest {
    @Test
    public void testUniversityJsonSerialization() {
        Student student1 = new Student("John", "Doe", "Smith", Sex.MALE);
        Student student2 = new Student("Jane", "Smith", "Doe", Sex.FEMALE);
        Group group1 = new Group("Group 1", student1);
        Group group2 = new Group("Group 2", student2);
        Department department1 = new Department("Department 1", group1);
        Department department2 = new Department("Department 2", group2);
        Faculty faculty1 = new Faculty("Faculty 1", department1);
        Faculty faculty2 = new Faculty("Faculty 2", department2);
        University oldUniversity = new University("My University", Collections.singletonList(faculty1));

        faculty1.setDepartment(new Department("Department 3",
                new Group("Group 3", new Student("Tom", "Smith", "Doe", Sex.MALE))));
        faculty2.setDepartment(new Department("Department 4",
                new Group("Group 4", new Student("Alice", "Doe", "Smith", Sex.FEMALE))));

        String filePath = "university.json";

        JSONUtils.writeUniversityToJsonFile(oldUniversity, filePath);

        University newUniversity = JSONUtils.readUniversityFromJsonFile(filePath);
    }
}