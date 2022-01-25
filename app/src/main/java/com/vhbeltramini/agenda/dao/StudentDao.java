package com.vhbeltramini.agenda.dao;

import com.vhbeltramini.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final static List<Student> students = new ArrayList<>();

    private static Integer idCounter = 1;

    public void saveStudent(Student student) {
        student.setId(idCounter);
        students.add(student);
        idCounter++;
    }

    public void edit(Student student) {
        students.stream()
                .filter(s -> s.getId().equals(student.getId()))
                .findFirst()
                .ifPresent(value -> students.set(students.indexOf(value), student));
    }

    public List<Student> all() {
        return new ArrayList<>(students);
    }

    public void delete(Student student) {
        students.stream()
                .filter(s -> s.getId().equals(student.getId()))
                .findFirst()
                .ifPresent(students::remove);
    }

}
