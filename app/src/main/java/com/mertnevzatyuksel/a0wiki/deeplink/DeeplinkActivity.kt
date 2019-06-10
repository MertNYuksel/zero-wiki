package com.mertnevzatyuksel.a0wiki.deeplink

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import com.mertnevzatyuksel.a0wiki.R

class DeeplinkActivity : AppCompatActivity() {

    val replaceDomainUseCase by lazy(LazyThreadSafetyMode.NONE) {
        ReplaceDomainUseCase()
    }

    val webBrowserIntentResolver by lazy(LazyThreadSafetyMode.NONE) {
        WebBrowserIntentResolver()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleDeeplink(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink)
        handleDeeplink(intent)
    }

    private fun handleDeeplink(intent: Intent?) {
        val intentData = intent?.data ?: return
        val newDomain = "wikipedi0.org"
        val replacedDomain = replaceDomainUseCase.replaceDomain(intentData, newDomain)

        runCatching {
            webBrowserIntentResolver.getWebBrowserIntent(this)?.apply {
                data = replacedDomain
            }?.let(::startActivity)
        }.onFailure { onBrowserIntentFailed(replacedDomain) }
            .onSuccess { onBrowserIntentSucceed() }

        finish()
    }

    private fun onBrowserIntentSucceed() {
        logSucceedBrowserIntent()
    }

    private fun logSucceedBrowserIntent() {

    }


    private fun onBrowserIntentFailed(replacedDomain: Uri) {
        logFailedBrowserIntent()
        startCustomTabs(replacedDomain)
    }

    private fun logFailedBrowserIntent() {

    }
    
    private fun startCustomTabs(url: Uri) {
        CustomTabsIntent.Builder().build().launchUrl(this, url);
    }

}
