package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Flowable.just("red","yellow","white","blue")
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe(
                {value -> println("Recieved: $value")},
                { error -> println("Error: $error")},
                { println("Completed")}
            ).dispose()
    }
}