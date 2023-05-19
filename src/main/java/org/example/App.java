package org.example;

import controller.*;
import model.*;
import view.*;

public class App
{
    public static void main( String[] args )
    {
        Student student = new Student("Olexander", "Burlaka", "Bura", Sex.MALE);
        Group group = new Group("122-20-2", student);
        Department department = new Department("Department", group);
        Faculty faculty = new Faculty("FIT", department);
        University university = new University("NTU DP", faculty);

        UniversityView universityView = new UniversityView();
        UniversityController universityController = new UniversityController(university, universityView);

        universityController.displayUniversityDetails();
    }
}
