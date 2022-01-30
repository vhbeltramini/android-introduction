package com.vhbeltramini.agenda;

import android.app.Application;

import com.vhbeltramini.agenda.dao.StudentDao;
import com.vhbeltramini.agenda.model.Student;

public class ApplicationAgenda extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        StudentDao studentDao = new StudentDao();

        studentDao.saveStudent(new Student("Victor", "7777-7777", "vh@gmail.com"));
        studentDao.saveStudent(new Student("Maits", "7777-7777", "maits@gmail.com"));

    }
}
