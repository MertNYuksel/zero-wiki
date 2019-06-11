package com.mertnevzatyuksel.a0wiki.remoteconfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.mertnevzatyuksel.a0wiki.remoteconfig.RemoteConfigWrapper.Companion.NEW_DOMAIN_WITHOUT_SUBDOMAIN_KEY

class RemoteConfigInitializer {
    val remoteConfig by lazy(LazyThreadSafetyMode.NONE) { FirebaseRemoteConfig.getInstance() }

    fun init() {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(60)
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.fetchAndActivate()

        remoteConfig.setDefaults(getDefaultConfigValues())
    }

    private fun getDefaultConfigValues() = mapOf<String, Any>(
        NEW_DOMAIN_WITHOUT_SUBDOMAIN_KEY to "0wikipedia.org"
    )

}