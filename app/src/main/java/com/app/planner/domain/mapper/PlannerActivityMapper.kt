package com.app.planner.domain.mapper

import com.app.planner.data.database.PlannerActivityEntity
import com.app.planner.domain.model.PlannerActivity

fun PlannerActivityEntity.toDomain(): PlannerActivity =
    PlannerActivity(
        uuid = this.uuid,
        name = this.name,
        dateTime = this.dateTime,
        isCompleted = this.isCompleted

    )
fun PlannerActivity.toEntity(id: Int): PlannerActivityEntity =
    PlannerActivityEntity(
        id = id,
        uuid = this.uuid,
        name = this.name,
        dateTime = this.dateTime,
        isCompleted = this.isCompleted
    )