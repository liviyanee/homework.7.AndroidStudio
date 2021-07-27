package com.example.homework7androidstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvTask;
    RecyclerAdapter adapter;
    FloatingActionButton btnOpenAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTask = findViewById(R.id.rv_task);
        btnOpenAddTask = findViewById(R.id.btn_open_add_task);
        adapter = new RecyclerAdapter(this);
        rvTask.setAdapter(adapter);

        btnOpenAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            String title = data.getStringExtra("title");
            String description = data.getStringExtra("description");
            TaskModel model = new TaskModel(title, description);
            adapter.addTask(model);
        }
    }
}