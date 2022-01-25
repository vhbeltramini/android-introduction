package com.vhbeltramini.agenda.dao;

import com.vhbeltramini.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final static List<Student> students = new ArrayList<>();

    public void saveStudent(Student student) {
        students.add(student);
    }

    public List<Student> all() {
        return new ArrayList<>(students);
    }
}
