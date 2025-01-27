package com.app.planner.domain.model

import android.icu.util.Calendar
import com.app.planner.domain.utils.createCalendarFromTimeInMillis
import com.app.planner.domain.utils.toPlannerActivityDate
import com.app.planner.domain.utils.toPlannerActivityDateTime
import com.app.planner.domain.utils.toPlannerActivityTime

data class PlannerActivity(
    val uuid:String,
    val name:String,
    val dateTime: Long,
    val isCompleted:Boolean
){
    private val dateTimeCalendar : Calendar = createCalendarFromTimeInMillis(dateTime)
    
    val dateString:String = dateTimeCalendar.toPlannerActivityDate()
    val timeString:String = dateTimeCalendar.toPlannerActivityTime()
    val dateTimeString:String = dateTimeCalendar.toPlannerActivityDateTime()
}
