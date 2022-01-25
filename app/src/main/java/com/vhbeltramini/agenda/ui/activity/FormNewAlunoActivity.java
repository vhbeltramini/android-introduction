package com.vhbeltramini.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.vhbeltramini.agenda.R;
import com.vhbeltramini.agenda.dao.StudentDao;
import com.vhbeltramini.agenda.model.Student;

public class FormNewAlunoActivity extends AppCompatActivity {

    private EditText nameForm;
    private EditText emailForm;
    private EditText phoneForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_new_aluno);
        setTitle("New Students");
        startForm();
        handleSave();
    }


    private void startForm() {
        nameForm =  findViewById(R.id.activity_form_student_name);
        emailForm =  findViewById(R.id.activity_form_student_email);
        phoneForm =  findViewById(R.id.activity_form_student_phone);
    }

    private Student createStudent() {
        String name = nameForm.getText().toString();
        String phone = phoneForm.getText().toString();
        String email = emailForm.getText().toString();
        return new Student(name, phone, email);
    }

    private void handleSave() {
        StudentDao studentDao = new StudentDao();
        Button saveButton = findViewById(R.id.activity_form_student_save_button);
        saveButton.setOnClickListener(v -> {
            studentDao.saveStudent(
                    createStudent()
            );
            finish();
        });
    }

}