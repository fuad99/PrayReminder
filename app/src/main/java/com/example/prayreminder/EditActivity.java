package com.example.prayreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prayreminder.adapter.TaskAdapter;
import com.example.prayreminder.db.AppDatabase;
import com.example.prayreminder.db.entity.Task;

import java.util.List;

public class EditActivity extends AppCompatActivity {

    EditText etKegiatanEdit,etKeteranganEdit,etJamEdit;
    Button btUpdate,btDelete,btBack;
    AppDatabase database;
    List<Task> mList;
    public static final String DUMMY_PASSWORD = "dtsrocks";
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etJamEdit = findViewById(R.id.edt_jam_edit);
        etKegiatanEdit = findViewById(R.id.edt_nama_kegiatan_edit);
        etKeteranganEdit = findViewById(R.id.edt_keterangan_edit);
        btBack = findViewById(R.id.bt_back_edit);
        btDelete = findViewById(R.id.bt_delete_edit);
        btUpdate = findViewById(R.id.bt_ubah_edit);

        String data =getIntent().getParcelableExtra(DUMMY_PASSWORD);
        etJamEdit.setText(data);

//        etJamEdit.setText(task.getJadwal());
//        etKeteranganEdit.setText(task.getKeterangan());
//        etKegiatanEdit.setText(task.getKegiatan());
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "product").fallbackToDestructiveMigration().allowMainThreadQueries()
                .build();

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String kegiatan = etKegiatanEdit.getText().toString();
                 String jadwal = etJamEdit.getText().toString();
                 String keterangan  = etKeteranganEdit.getText().toString();

                Task tasku = new Task();
//                tasku.setId(String.valueOf(getTaskId()));
                tasku.setJadwal(jadwal);
                tasku.setKegiatan(kegiatan);
                tasku.setKeterangan(keterangan);

                database.databaseInterface().updateTask(tasku);
                Toast.makeText(getApplicationContext(),"Berhasil DiUpdate!",Toast.LENGTH_SHORT).show();
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.databaseInterface().deleteTask(task);
                Toast.makeText(getApplicationContext(),"Berhasil Dihapus!",Toast.LENGTH_SHORT).show();
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditActivity.this,MainActivity.class));
            }
        });
    }
}
