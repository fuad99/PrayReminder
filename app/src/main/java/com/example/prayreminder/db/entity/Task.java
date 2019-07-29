package com.example.prayreminder.db.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task implements Parcelable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //    @NonNull
//    String id;
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "kegiatan")
    String kegiatan;

    @ColumnInfo(name = "keterangan")
    String keterangan;

    @ColumnInfo(name = "jadwal")
    String jadwal;

    public Task(){

    }

    public Task( String kegiatan, String keterangan, String jadwal) {

        this.kegiatan = kegiatan;
        this.keterangan = keterangan;
        this.jadwal = jadwal;
    }

    protected Task(Parcel in) {

        kegiatan = in.readString();
        keterangan = in.readString();
        jadwal = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };



    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(kegiatan);
        parcel.writeString(keterangan);
        parcel.writeString(jadwal);
    }
}
