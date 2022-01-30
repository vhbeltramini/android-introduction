package com.vhbeltramini.agenda.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vhbeltramini.agenda.R;
import com.vhbeltramini.agenda.dao.StudentDao;
import com.vhbeltramini.agenda.model.Student;
import com.vhbeltramini.agenda.ui.adapter.ListStudentsAdapter;


import static com.vhbeltramini.agenda.ui.activity.DataConstants.STUDENT_KEY;


public class ListStudentsActivity extends AppCompatActivity {

    final private StudentDao studentDao = new StudentDao();
    private ListView studentsListView;
    private ListStudentsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);
        setTitle("All Students");

        handleListStudentes();
        openFormAddNewStudent();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_list_students_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.activity_list_students_button_remove) {
            handleRemoveStudent(item);
        }
        return super.onContextItemSelected(item);
    }

    private void handleRemoveStudent(final MenuItem item) {
        new AlertDialog
                .Builder(this)
                .setTitle("Removing Student")
                .setMessage("You really want to remove this student ?")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                        Student student = adapter.getItem(menuInfo.position);
                        studentDao.delete(student);
                        adapter.remove(student);
                })
                .setNegativeButton("No", null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        adapter.addAll(studentDao.all());
    }

    private void handleListStudentes() {
        studentsListView = findViewById(R.id.activity_list_students_listview);
        handleStudentsAdapter();
        handleStudentListSelection();
        registerForContextMenu(studentsListView);
    }

    private void handleStudentsAdapter() {
        adapter = new ListStudentsAdapter(this);
        studentsListView.setAdapter(adapter);
    }

    private void handleStudentListSelection() {
        handleSimpleClickStudentList();
    }

    private void handleSimpleClickStudentList() {
        studentsListView.setOnItemClickListener((adapterView, view, position, id) -> {
                Student student = (Student) adapterView.getItemAtPosition(position);
                openFormForEdit(student);
            }
        );
    }

    private void openFormForEdit(Student student) {
        Intent goToFormStudentWithData = new Intent(ListStudentsActivity.this, FormNewStudentActivity.class);
        goToFormStudentWithData.putExtra(STUDENT_KEY, student);
        startActivity(goToFormStudentWithData);
    }

    private void openFormAddNewStudent() {
        FloatingActionButton addStudentButton = findViewById(R.id.activity_list_students_button_new_student);
        addStudentButton.setOnClickListener(v -> startActivity(new Intent(ListStudentsActivity.this, FormNewStudentActivity.class)));
    }

}
