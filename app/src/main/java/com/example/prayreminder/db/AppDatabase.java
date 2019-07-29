package com.example.prayreminder.db;

import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.prayreminder.db.dao.TaskDao;
import com.example.prayreminder.db.entity.Task;

@Database(entities = {Task.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao databaseInterface();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
