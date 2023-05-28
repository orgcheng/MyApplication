package com.example.myapplication

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import android.util.Log

class App :Application() {
    override fun onCreate() {
        super.onCreate()
        startForegroundService(Intent(this, MyForegroundService::class.java))

        this.registerReceiver(MyBroadcastReceiver(), IntentFilter(MyBroadcastReceiver.ACTION))

//        MyAlarmManager.setAlarm(this, getMillisecondsUsingCalendar(22,54), MyAlarmManager.REQUEST_CODE_PM)
        MyAlarmManager.setAlarm(this, getMillisecondsUsingCalendar(23,35), MyAlarmManager.REQUEST_CODE_AM)

//        MyAlarmManager.setAlarm(this, getMillisecondsUsingCalendar(8,40), MyAlarmManager.REQUEST_CODE_AM)
//        MyAlarmManager.setAlarm(this, getMillisecondsUsingCalendar(21,6), MyAlarmManager.REQUEST_CODE_PM)
    }
}