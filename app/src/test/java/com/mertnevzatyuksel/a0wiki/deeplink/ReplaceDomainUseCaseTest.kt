package com.mertnevzatyuksel.a0wiki.deeplink

import android.net.Uri
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class ReplaceDomainUseCaseTest {

    @Test
    fun replaceDomainUseCaseReplacesDomainWithNewDomain() {
        // Given
        val replaceDomainUseCaseTest = ReplaceDomainUseCase()
        val oldUri = Uri.parse("https://tr.wikipedia.org/wiki/Android_(işletim_sistemi)")

        // When
        val newUri= replaceDomainUseCaseTest.replaceDomain(oldUri, "0wikipedia.org")

        // Then
        Assert.assertEquals(
            "https://tr.0wikipedia.org/wiki/Android_(işletim_sistemi)",
            newUri.toString())
    }
}