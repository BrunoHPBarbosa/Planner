package com.app.planner.data.datasource

import kotlinx.coroutines.flow.Flow

interface AuthenticationLocalDataSource {

    val token: Flow<String>

    val expirationDateTime: Flow<Long>

    suspend fun insertToken(token: String)
}