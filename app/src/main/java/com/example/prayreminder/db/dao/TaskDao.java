package com.example.prayreminder.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prayreminder.db.entity.Task;

import java.util.List;


@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task>getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Task... task);
    @Update
    void updateTask(Task tasks);
    @Delete
    void deleteTask(Task tasks);
}
