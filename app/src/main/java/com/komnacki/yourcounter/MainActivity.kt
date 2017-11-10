package com.komnacki.yourcounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var c = 0
    var lc = 0
    var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        linearlayout_main.setOnLongClickListener({longClick()})
        linearlayout_main.setOnClickListener({click()})


        val COUNTER = object : Thread() {
            override fun run() {

                while (!isInterrupted) {
                    try {
                        //Counter frequence (in miliseconds)
                        Thread.sleep(1000)
                        runOnUiThread {
                            timer.seconds += 1
                            tv_seconds.text = timer.seconds.toString()
                        }
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }
        COUNTER.start()
    }



    fun click(){
        Toast.makeText(this, "Clicked! " + c, Toast.LENGTH_SHORT).show()
    }

    fun longClick() : Boolean{
        Toast.makeText(this, "Long click! " + lc, Toast.LENGTH_LONG).show()
        return false
    }
}
