package com.komnacki.yourcounter



class Timer{
    var hours = 0
    var minutes = 0
    var seconds = 0
    var miliseconds = 0
    var isRun = false

    fun add(miliseconds:Int){
        this.miliseconds += miliseconds
        update()
    }

    fun reset(){
        this.hours = 0
        this.minutes = 0
        this.seconds = 0
        this.miliseconds = 0
        isRun = false
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
