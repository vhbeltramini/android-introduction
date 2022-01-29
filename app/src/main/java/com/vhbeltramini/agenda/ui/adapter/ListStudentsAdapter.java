package com.vhbeltramini.agenda.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vhbeltramini.agenda.R;
import com.vhbeltramini.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ListStudentsAdapter extends BaseAdapter {

    private final List<Student> students = new ArrayList<>();
    private final Context context;

    public ListStudentsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return students.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
         View createdView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_student, viewGroup, false);

        Student student = students.get(position);

        TextView nameField = createdView.findViewById(R.id.item_student_name);
        nameField.setText(student.getName());
        TextView phoneField = createdView.findViewById(R.id.item_student_phone);
        phoneField.setText("Phone : " + student.getPhone());

        return createdView;
    }

    public void remove(Student student) {
        students.remove(student);
    }

    public void clear() {
        students.clear();
    }

    public void addAll(List<Student> all) {
        students.addAll(all);
    }

}
