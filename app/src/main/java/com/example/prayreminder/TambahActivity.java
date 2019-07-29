package com.example.prayreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prayreminder.db.AppDatabase;
import com.example.prayreminder.db.entity.Task;

import java.util.List;

public class TambahActivity extends AppCompatActivity {
    EditText etKegiatan, etKeterangan, etJadwal;
    Button btUbah, btHapus, btBack;
    AppDatabase database;
    List<Task> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        etKegiatan = findViewById(R.id.edt_nama_kegiatan_edit);
        etJadwal = findViewById(R.id.edt_jam_edit);
        etKeterangan = findViewById(R.id.edt_keterangan_edit);
        btBack = findViewById(R.id.bt_back_edit);
        btHapus = findViewById(R.id.bt_delete_edit);
        btUbah = findViewById(R.id.bt_tambahkan);

        btHapus.setEnabled(false);

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "product").fallbackToDestructiveMigration().allowMainThreadQueries()
                .build();

        btUbah.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                 String kegiatan = etKegiatan.getText().toString();
                 String jadwal = etJadwal.getText().toString();
                 String keterangan  = etKeterangan.getText().toString();



                 Task tasku = new Task();
//                tasku.setId(String.valueOf(getTaskId()));
                tasku.setJadwal(jadwal);
                tasku.setKegiatan(kegiatan);
                tasku.setKeterangan(keterangan);

                database.databaseInterface().insertAll(tasku);
                Toast.makeText(getApplicationContext(),"Berhasil Ditambahkan!",Toast.LENGTH_SHORT).show();

            }
        });



        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TambahActivity.this,MainActivity.class));
            }
        });
    }

//    public void insertData(){
//        final String kegiatan = etKegiatan.getText().toString();
//        final String jadwal = etJadwal.getText().toString();
//        final String keterangan  = etKeterangan.getText().toString();
//
//
//
//        class insertData extends AsyncTask<Void,Void,Void>{
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                Task task = new Task();
//                task.setKeterangan(keterangan);
//                task.setKegiatan(kegiatan);
//                task.setJadwal(jadwal);
//
//                return null;
//            }
//        }
//        db.databaseInterface().insertAll(task);
//    }
}
