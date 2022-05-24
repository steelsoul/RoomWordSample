package com.alex.roomwordsample

import android.app.Application
import com.alex.roomwordsample.model.WordRepository
import com.alex.roomwordsample.model.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    // database and repository are created when they are needed
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }

}