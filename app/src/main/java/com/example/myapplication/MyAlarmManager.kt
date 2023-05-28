package com.example.myapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

object MyAlarmManager {
    const val REQUEST_CODE_PM = 100
    const val REQUEST_CODE_AM = 200

    fun setAlarm(context: Context, triggerTime: Long, code: Int, repeatCount: Int = 4) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // 创建一个Intent，用于指定要执行的操作
        val intent = Intent(MyBroadcastReceiver.ACTION)
        intent.putExtra("triggerTime", triggerTime)
        intent.putExtra("repeatCount", repeatCount)
        intent.putExtra("code", code)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            code,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        // 设置定时任务
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent)
    }

    fun cancelAlarm(context: Context, code: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // 创建一个与之前设置的pendingIntent相同的Intent
        val intent = Intent(MyBroadcastReceiver.ACTION)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            code,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        // 取消定时任务
        alarmManager.cancel(pendingIntent)
    }
}