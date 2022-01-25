package com.vhbeltramini.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vhbeltramini.agenda.R;
import com.vhbeltramini.agenda.dao.StudentDao;


public class ListStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);
        setTitle("All Students");

        FloatingActionButton addStudentButton = findViewById(R.id.activity_list_students_button_new_student);
        addStudentButton.setOnClickListener(v -> startActivity(new Intent(ListStudentsActivity.this, FormNewAlunoActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataStudents();

    }

    private void getDataStudents() {
        StudentDao studentDao = new StudentDao();
        ListView studentsListView = findViewById(R.id.activity_list_students_listview);
        studentsListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentDao.all()));
    }

}
