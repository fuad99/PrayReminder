package com.example.prayreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.prayreminder.adapter.TaskAdapter;
import com.example.prayreminder.db.AppDatabase;
import com.example.prayreminder.db.entity.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase database;
    Button btAdd;
    List<Task> mList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvPray);
        btAdd = findViewById(R.id.bt_add);


        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "product").fallbackToDestructiveMigration().allowMainThreadQueries()
                .build();

                mList = database.databaseInterface().getAll();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        adapter = new TaskAdapter(mList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,TambahActivity.class);

                startActivity(i);
            }
        });

    }
}
