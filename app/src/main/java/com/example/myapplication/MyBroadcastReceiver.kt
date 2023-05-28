package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val triggerTime = intent.getLongExtra("triggerTime", 0)
        val code = intent.getIntExtra("code", 0)
        val repeatCount = intent.getIntExtra("repeatCount", 0)
        Log.e("fuck", "onReceive code $code, repeatCount $repeatCount")
        if (repeatCount == 4 || repeatCount == 2) {
            // 启动钉钉
            startApp(context, "com.android.settings")

        } else if (repeatCount == 3 || repeatCount == 1) {
            // 启动应用
            startApp(context, context.packageName)
        }

        if (repeatCount > 0) {
            // 定时执行下一个动作
            MyAlarmManager.setAlarm(context, getNextMinuteUsingCalendar(), code, repeatCount - 1)
        }
    }

    private fun startApp(context:Context, packageName: String) {
        var intent = context.packageManager.getLaunchIntentForPackage(packageName)
        Log.e("fuck", "startApp $packageName  $intent")
        intent?.let {
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(it)
        }
    }

    companion object {
        const val ACTION = "com.example.myapplication.action.alarm"
    }
}