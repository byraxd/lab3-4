package controller;

import model.*;
import view.UniversityView;

import java.util.List;

public class UniversityController {
    private University university;
    private UniversityView universityView;

    // Конструктор
    public UniversityController(University university, UniversityView universityView) {
        this.university = university;
        this.universityView = universityView;
    }

    // Геттери і сеттери
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public UniversityView getUniversityView() {
        return universityView;
    }

    public void setUniversityView(UniversityView universityView) {
        this.universityView = universityView;
    }

    // Метод для відображення деталей університету
    public static void displayUniversityDetails(University university) {
        System.out.println("University: " + university.getName());
        List<Faculty> faculties = university.getFaculties();
        for (Faculty faculty : faculties) {
            System.out.println("Faculty: " + faculty.getName());
            Department department = faculty.getDepartment();
            System.out.println("Department: " + department.getName());
            Group group = department.getGroup();
            System.out.println("Group: " + group.getName());
            Student student = group.getStudent();
            System.out.println("Student: " + student.getName() + " " + student.getSurname());
            System.out.println("-----------------------------");
        }
    }
}