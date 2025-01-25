package com.app.planner.domain

import android.icu.util.Calendar
import java.util.Locale

private val sdfPlannerActivityDateTime  = android.icu.text.SimpleDateFormat("EEE dd'\n'HH:mm", Locale("pt","PT"))
private val sdfPlannerActivityDate  = android.icu.text.SimpleDateFormat("dd 'de' MMMM", Locale("pt","PT"))
private val sdfPlannerActivityTime  = android.icu.text.SimpleDateFormat("HH:mm", Locale("pt","PT"))

fun createCalendarFromTimeInMillis(timeInMillis: Long): Calendar {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis  = timeInMillis
    return calendar
}

fun Calendar.toPlannerActivityDateTime(): String = sdfPlannerActivityDateTime.format(this)
fun Calendar.toPlannerActivityDate(): String = sdfPlannerActivityDate.format(this)
fun Calendar.toPlannerActivityTime(): String = sdfPlannerActivityTime.format(this)
