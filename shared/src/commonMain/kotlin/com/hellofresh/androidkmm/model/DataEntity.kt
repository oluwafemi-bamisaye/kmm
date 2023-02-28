package com.hellofresh.androidkmm.model

import com.hellofresh.androidkmm.ApiClass

object DataEntity {
    suspend fun data(): List<Entries> = ApiClass().getEntries().list
}