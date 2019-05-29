package com.mertnevzatyuksel.a0wiki.deeplink

import android.net.Uri

class ReplaceDomainUseCase {

    fun replaceDomain(oldURL: Uri, newDomainWithoutSubdomain: String): Uri {
        val oldAuthority = requireNotNull(oldURL.authority ?: oldURL.host)
        val newAuthority = oldAuthority.replace("wikipedia.org", newDomainWithoutSubdomain)
        return oldURL.buildUpon().authority(newAuthority).build()
    }
}