package com.komnacki.yourcounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    var timer = Timer()
    val TIME_PERIOD = 100
    val updateHandler = Handler()
    val runnable = Runnable { timerRun() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        linearlayout_main.setOnLongClickListener({longClick()})
        linearlayout_main.setOnClickListener({click()})
    }

    fun click(){
        if(timer.isRun){
            timer.isRun=false

        }else{
            timer.isRun = true
            runnable.run()
        }
        Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show()
    }

    fun longClick() : Boolean{
        timer.reset()
        updateLayout()
        Toast.makeText(this, "Long click!", Toast.LENGTH_SHORT).show()
        return true
    }


    fun timerRun(){
        if(timer.isRun){
            updateHandler.postDelayed(runnable, TIME_PERIOD.toLong())
            timer.add(TIME_PERIOD)
            updateLayout()
        }
    }

    fun updateLayout(){
        if(tv_hours.visibility.equals(View.VISIBLE)) tv_hours.text = timer.hours.toString()
        if(tv_minutes.visibility.equals(View.VISIBLE)) tv_minutes.text = timer.minutes.toString()
        if(tv_seconds.visibility.equals(View.VISIBLE)) tv_seconds.text = timer.seconds.toString()
        if(tv_miliseconds.visibility.equals(View.VISIBLE)) tv_miliseconds.text = timer.miliseconds.toString().substring(0,1)
    }
}
