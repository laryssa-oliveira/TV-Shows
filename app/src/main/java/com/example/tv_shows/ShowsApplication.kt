package com.example.tv_shows

import android.app.Application
import com.example.di.*
import com.example.di.intent.intentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class ShowsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            modules(
                intentModule +
                        listOf(
                            presentationModule,
                            dataModule,
                            dataLocalModule,
                            dataRemoteModule,
                            domainModule
                        )
            ).androidContext(applicationContext)
        }
    }
}