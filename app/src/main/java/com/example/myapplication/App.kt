package com.example.myapplication

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import android.util.Log

class App :Application() {
    override fun onCreate() {
        super.onCreate()
        // 启动前台服务
        startForegroundService(Intent(this, MyForegroundService::class.java))

        // 注册装逼接收器，用来拉起钉钉和应用程序到前台
        this.registerReceiver(MyBroadcastReceiver(), IntentFilter(MyBroadcastReceiver.ACTION))

        MyAlarmManager.setAlarm(this, getMillisecondsUsingCalendar(23,35), MyAlarmManager.REQUEST_CODE_AM)

        // 设置上下班自动打卡时间
//        MyAlarmManager.setAlarm(this, getMillisecondsUsingCalendar(8,40), MyAlarmManager.REQUEST_CODE_AM)
//        MyAlarmManager.setAlarm(this, getMillisecondsUsingCalendar(21,6), MyAlarmManager.REQUEST_CODE_PM)
    }
}