package com.example.roomdatabase26112019.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import io.reactivex.Observable;

@Dao
public interface SinhvienDao {

    @Query("SELECT * FROM sinhvien")
    Observable<List<Sinhvien>> getAll();

    @Insert
    List<Long> insertSinhvien(Sinhvien... sinhviens);
}
