package com.example.roomdatabase

import android.app.Application
import android.content.Context
import com.example.roomdatabase.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
//
//    companion object{
//        var  application:Context?=null
//    }
//    override fun onCreate() {
//        super.onCreate()
//        application = this
//        startKoin {
//            modules(dataDaoModule, modelDao, repoModule, viewModelModule)
//        }
//
//    }

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MyApplication)
            injectFeature()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}