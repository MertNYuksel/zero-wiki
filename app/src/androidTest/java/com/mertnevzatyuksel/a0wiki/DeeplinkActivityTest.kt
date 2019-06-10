package com.mertnevzatyuksel.a0wiki

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DeeplinkActivityTest {

    @Test
    fun actionViewIntentWithWikipediaDomainTriggersApp() {
        // Given
        val intent = Intent(ACTION_VIEW, Uri.parse("https://www.wikipedia.org"))
        // When
        val resolveInfos = ApplicationProvider.getApplicationContext<Context>().packageManager.queryIntentActivities(intent, 0)

        // Then
        val foundResolveInfo = resolveInfos.find { it.activityInfo?.applicationInfo?.packageName == BuildConfig.APPLICATION_ID }
        Truth.assertThat(foundResolveInfo).isNotNull()
    }
}