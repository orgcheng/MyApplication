package com.example.myapplication

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun getMillisecondsUsingCalendar(hour: Int, minute: Int): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MINUTE, minute)
    calendar.set(Calendar.HOUR_OF_DAY, hour)

    var date = Date(calendar.timeInMillis)
    var simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    var timeStr = simpleDateFormat.format(date)
    Log.e("fuck", "getMillisecondsUsingCalendar $timeStr")
    return calendar.timeInMillis
}
fun getNextMinuteUsingCalendar(): Long {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.MINUTE, 1)

    var date = Date(calendar.timeInMillis)
    var simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    var timeStr = simpleDateFormat.format(date)
    Log.e("fuck", "getNextMinuteUsingCalendar $timeStr")
    return calendar.timeInMillis
}
