package com.mertnevzatyuksel.a0wiki

import android.app.Application
import com.mertnevzatyuksel.a0wiki.remoteconfig.RemoteConfigInitializer


class ZeroWikiApp: Application() {

    val remoteConfigInitializer = RemoteConfigInitializer()

    override fun onCreate() {
        super.onCreate()
        remoteConfigInitializer.init()
    }
}