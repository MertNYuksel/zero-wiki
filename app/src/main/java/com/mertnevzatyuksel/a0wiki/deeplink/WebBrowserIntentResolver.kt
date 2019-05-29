package com.mertnevzatyuksel.a0wiki.deeplink

import android.content.Context
import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri

class WebBrowserIntentResolver constructor() {

    fun getWebBrowserIntent(context: Context): Intent? {
        val browsers = getWebBrowsers(context)
        val browserPackageName = getWebBrowserPackageName(browsers) { it.activityInfo.applicationInfo.targetSdkVersion }
        return context.packageManager.getLaunchIntentForPackage(browserPackageName)
    }

    private fun getWebBrowserPackageName(browsers: List<ResolveInfo>, predicate: (ResolveInfo) -> Int): String {
        return browsers.sortedByDescending { predicate(it) }.first().activityInfo.packageName
    }

    private fun getWebBrowsers(context: Context): List<ResolveInfo> {
        return context.packageManager.queryIntentActivities(getImplicitHttpsIntent(), 0).filter { it.activityInfo.isEnabled }
    }

    private fun getImplicitHttpsIntent() = Intent(Intent.ACTION_VIEW, Uri.parse("https://"))
}