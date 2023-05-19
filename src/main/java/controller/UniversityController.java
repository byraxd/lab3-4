package controller;

import model.*;
import view.UniversityView;

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
    public void displayUniversityDetails() {
        String universityName = university.getName();
        String facultyName = university.getFaculty().getName();
        String departmentName = university.getFaculty().getDepartment().getName();
        String groupName = university.getFaculty().getDepartment().getGroup().getName();
        String studentName = university.getFaculty().getDepartment().getGroup().getStudent().getName();

        universityView.printUniversityDetails(universityName, facultyName, departmentName, groupName, studentName);
    }
}