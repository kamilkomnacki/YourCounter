package com.komnacki.yourcounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import android.view.Window
import android.widget.Toast
import com.komnacki.yourcounter.R.id.tv_minutes
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    var timer = Timer()
    var time = Time()



    val updateHandler = Handler()
    val timerThread = Runnable { timerRun() }




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
            timerThread.run()
        }
        Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show()
    }

    fun longClick() : Boolean{
        time.reset()
        timer.isRun = false
        updateLayout()
        Toast.makeText(this, "Long click!", Toast.LENGTH_SHORT).show()
        return true
    }

    fun timerRun(){
        if(timer.isRun){
            updateHandler.postDelayed(timerThread, timer.TIME_PERIOD.toLong())
            time.add(timer.TIME_PERIOD)
            updateLayout()
        }
    }

    fun updateLayout(){
        if(tv_hours.visibility.equals(View.VISIBLE)) tv_hours.text = time.hours.toString()
        if(tv_minutes.visibility.equals(View.VISIBLE)) tv_minutes.text = time.minutes.toString()
        if(tv_seconds.visibility.equals(View.VISIBLE)) tv_seconds.text = time.seconds.toString()
        if(tv_miliseconds.visibility.equals(View.VISIBLE)) tv_miliseconds.text = time.miliseconds.toString().substring(0,1)

    }





}
