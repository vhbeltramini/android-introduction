package com.vhbeltramini.agenda.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.vhbeltramini.agenda.R;
import com.vhbeltramini.agenda.dao.StudentDao;
import com.vhbeltramini.agenda.model.Student;
import static com.vhbeltramini.agenda.ui.activity.DataConstants.STUDENT_KEY;

public class FormNewAlunoActivity extends AppCompatActivity {

    public static final String EDIT_STUDENT_TITLE = "Edit Student";
    public static final String NEW_STUDENT_TITLE = "New Student";
    private EditText nameForm;
    private EditText emailForm;
    private EditText phoneForm;
    private Student student;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_new_aluno);
        setTitle("New Students");
        studentDao = new StudentDao();

        startForm();
        handleFormData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_student_form_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        handleStudentSave();
        return super.onOptionsItemSelected(item);
    }

    private void startForm() {
        nameForm = findViewById(R.id.activity_form_student_name);
        emailForm = findViewById(R.id.activity_form_student_email);
        phoneForm = findViewById(R.id.activity_form_student_phone);
    }

    private Student fillStudent() {
        student.setName(nameForm.getText().toString());
        student.setPhone(phoneForm.getText().toString());
        student.setEmail(emailForm.getText().toString());

        return student;
    }

    private void handleStudentSave() {
        if (student.hasValidId()) {
            studentDao.edit(fillStudent());
        } else {
            studentDao.saveStudent(fillStudent());
        }
        finish();
    }

    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(STUDENT_KEY)) {
            student = (Student) data.getSerializableExtra("student");
            nameForm.setText(student.getName());
            phoneForm.setText(student.getPhone());
            emailForm.setText(student.getEmail());
            setTitle(EDIT_STUDENT_TITLE);
        } else {
            setTitle(NEW_STUDENT_TITLE);
            student = new Student();
        }
    }

}