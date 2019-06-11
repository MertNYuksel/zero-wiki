package com.mertnevzatyuksel.a0wiki.remoteconfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class RemoteConfigWrapper {
    fun getTargetDomain(): String {
        return FirebaseRemoteConfig.getInstance().getString(NEW_DOMAIN_WITHOUT_SUBDOMAIN_KEY)
    }

    companion object {
        val NEW_DOMAIN_WITHOUT_SUBDOMAIN_KEY = "new_domain_without_sub"
    }
}