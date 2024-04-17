package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", unique = true)
    private String fullName;

    private LocalDate birthDate;

    private Boolean married;

    public Employee() {
    }

    public Employee(long id, String fullName, LocalDate birthDate, Boolean married) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.married = married;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        married = married;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", isMarried=" + married +
                '}';
    }
}
