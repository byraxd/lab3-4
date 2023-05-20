package model;

import java.util.List;

public class University {
    private String name;
    private List<Faculty> faculties;

    // Конструктор
    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    // Геттери і сеттери
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}

