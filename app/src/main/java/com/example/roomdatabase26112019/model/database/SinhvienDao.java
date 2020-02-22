package com.example.roomdatabase26112019.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface SinhvienDao {

    @Query("SELECT * FROM sinhvien")
    Observable<List<Sinhvien>> getAll();

    @Insert
    Maybe<Integer> insertSinhvien(Sinhvien... sinhviens);
}
