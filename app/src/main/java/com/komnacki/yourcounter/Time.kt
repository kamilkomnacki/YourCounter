package com.komnacki.yourcounter

class Time{
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0
    var miliseconds: Int = 0

    fun add(miliseconds:Int){
        this.miliseconds += miliseconds
        update()
    }

    fun reset(){
        this.hours = 0
        this.minutes = 0
        this.seconds = 0
        this.miliseconds = 0
    }

    private fun update(){
        if(miliseconds>999){
            miliseconds = 0
            seconds += 1
        }

        if(seconds > 59){
            seconds = 0
            minutes += 1
        }

        if(minutes > 59){
            minutes = 0
            hours += 1
        }
    }
}
