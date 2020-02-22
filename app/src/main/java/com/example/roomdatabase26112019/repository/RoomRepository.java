package com.example.roomdatabase26112019.repository;

import android.content.Context;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.model.database.SinhvienDao;
import com.example.roomdatabase26112019.model.database.SinhvienDatabase;

import java.util.List;

import io.reactivex.Observable;


public class RoomRepository {
    private SinhvienDao sinhvienDao;
    private static RoomRepository roomRepository = null;

    private RoomRepository(Context context){
        SinhvienDatabase sinhvienDatabase = SinhvienDatabase.getInstance(context);
        sinhvienDao = sinhvienDatabase.sinhvienDao();
    }

    public static RoomRepository getInstance(Context context){
        if (roomRepository == null){
            roomRepository = new RoomRepository(context);
        }
        return roomRepository;
    }

    public Observable<List<Sinhvien>> getAllSinhvien(){
        return sinhvienDao.getAll();
    }

}
