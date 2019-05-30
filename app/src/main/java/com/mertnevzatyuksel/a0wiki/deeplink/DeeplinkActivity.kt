package com.mertnevzatyuksel.a0wiki.deeplink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mertnevzatyuksel.a0wiki.R

class DeeplinkActivity : AppCompatActivity() {

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
        val newDomain = "0wikipedia.org"
        val replacedDomain = ReplaceDomainUseCase().replaceDomain(intentData, newDomain)

        runCatching {
            WebBrowserIntentResolver().getWebBrowserIntent(this)?.let {
                it.data = replacedDomain
                startActivity(it)
            }
        }
            .onFailure { startWebViewActivity(replacedDomain.toString()) }
            .onSuccess { logSuccess() }

        finish()
    }

    private fun logSuccess() {

    }

    private fun startWebViewActivity(url: String) {

    }

}
