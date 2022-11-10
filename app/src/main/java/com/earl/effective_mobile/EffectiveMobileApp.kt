package com.earl.effective_mobile

import android.app.Application
import com.earl.effective_mobile.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class EffectiveMobileApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@EffectiveMobileApp)
            modules(listOf(
                networkModule,
                dataModule,
                mappersModule,
                domainModule,
                uiModule
            ))
        }
    }
}