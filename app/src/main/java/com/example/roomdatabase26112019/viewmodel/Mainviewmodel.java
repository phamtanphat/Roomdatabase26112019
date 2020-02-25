package com.example.roomdatabase26112019.viewmodel;

import android.content.Context;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.repository.RoomRepository;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Mainviewmodel extends ViewModel implements LifecycleObserver {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Sinhvien>> mutableLiveDataAraySinhvien = new MutableLiveData<>();

    public void getAllSinhvien(Context context) {
        RoomRepository
                .getInstance(context)
                .getAllSinhvien()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Sinhvien>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<Sinhvien> sinhviens) {
                        mutableLiveDataAraySinhvien.setValue(sinhviens);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public LiveData<List<Sinhvien>> getAllSinhvienSuccess(){
        return mutableLiveDataAraySinhvien;
    }
}
