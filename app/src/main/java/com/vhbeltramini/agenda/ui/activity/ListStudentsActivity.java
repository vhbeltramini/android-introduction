package com.vhbeltramini.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vhbeltramini.agenda.R;
import com.vhbeltramini.agenda.dao.StudentDao;
import com.vhbeltramini.agenda.model.Student;

import static com.vhbeltramini.agenda.ui.activity.DataConstants.STUDENT_KEY;


public class ListStudentsActivity extends AppCompatActivity {

    final private StudentDao studentDao = new StudentDao();
    ArrayAdapter<Student> adapter;
    private ListView studentsListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);
        setTitle("All Students");

        studentDao.saveStudent(new Student("Victor", "7777-7777", "vh@gmail.com"));
        studentDao.saveStudent(new Student("Maits", "7777-7777", "maits@gmail.com"));

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

    private void handleRemoveStudent(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Student student = adapter.getItem(menuInfo.position);
        studentDao.delete(student);
        adapter.remove(student);
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
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1);
        studentsListView.setAdapter(adapter);
    }

    private void handleStudentListSelection() {
        handleSimpleClickStudentList();
//        handleLongClickStudentList();
    }

    private void handleSimpleClickStudentList() {
        studentsListView.setOnItemClickListener((adapterView, view, position, id) -> {
                Student student = (Student) adapterView.getItemAtPosition(position);
                openFormForEdit(student);
            }
        );
    }

//    private void handleLongClickStudentList() {
//        studentsListView.setOnItemLongClickListener((adapterView, view, position, id) -> {
//                Student student = (Student) adapterView.getItemAtPosition(position);
//                studentDao.delete(student);
//                adapter.remove(student);
//                return false;
//            }
//        );
//    }

    private void openFormForEdit(Student student) {
        Intent goToFormStudentWithData = new Intent(ListStudentsActivity.this, FormNewAlunoActivity.class);
        goToFormStudentWithData.putExtra(STUDENT_KEY, student);
        startActivity(goToFormStudentWithData);
    }

    private void openFormAddNewStudent() {
        FloatingActionButton addStudentButton = findViewById(R.id.activity_list_students_button_new_student);
        addStudentButton.setOnClickListener(v -> startActivity(new Intent(ListStudentsActivity.this, FormNewAlunoActivity.class)));
    }

}
