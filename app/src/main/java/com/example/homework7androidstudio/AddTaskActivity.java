package com.example.homework7androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {
    EditText etTitle, etDescription;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
                if (!title.isEmpty() && !description.isEmpty()){
                    Intent intent = new Intent();
                    intent.putExtra("title", title);
                    intent.putExtra("description", description);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(AddTaskActivity.this, "Введите данные корректно", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }
