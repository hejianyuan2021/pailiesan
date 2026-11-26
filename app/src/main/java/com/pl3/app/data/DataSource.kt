package com.pl3.app.data

import com.pl3.app.algo.entity.Draw

interface DataSource {
    suspend fun fetchHistory(): List<Draw>
}
