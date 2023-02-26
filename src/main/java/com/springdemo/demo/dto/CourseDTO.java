package com.springdemo.demo.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private String id;
    private String name;
    private String type;
    private String grade;


    public CourseDTO() {
    }

    public CourseDTO(String id, String name, String type, String grade) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
