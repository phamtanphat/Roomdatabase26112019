package com.example.roomdatabase26112019.viewmodel;

import android.content.Context;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.repository.RoomRepository;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
//import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Mainviewmodel extends ViewModel implements LifecycleObserver {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Sinhvien>> mutableLiveDataAraySinhvien = new MutableLiveData<>();

    public LiveData<List<Sinhvien>> getAllSinhvien(Context context) {
        RoomRepository
                .getInstance(context)
                .getAllSinhvien()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Sinhvien>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Sinhvien> sinhviens) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        return mutableLiveDataAraySinhvien;
    }
}
