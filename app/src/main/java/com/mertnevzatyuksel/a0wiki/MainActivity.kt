package com.mertnevzatyuksel.a0wiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.frameLayoutAddressBarAnswer
import kotlinx.android.synthetic.main.activity_main.frameLayoutMailAnswer
import kotlinx.android.synthetic.main.activity_main.frameLayoutNoAdsAnswer
import kotlinx.android.synthetic.main.activity_main.frameLayoutNowWhatAnswer
import kotlinx.android.synthetic.main.activity_main.linearLayoutAddressBar
import kotlinx.android.synthetic.main.activity_main.linearLayoutAlwaysMisclick
import kotlinx.android.synthetic.main.activity_main.linearLayoutAlwaysMisclickAnswer
import kotlinx.android.synthetic.main.activity_main.linearLayoutDifferentBrowser
import kotlinx.android.synthetic.main.activity_main.linearLayoutDifferentBrowserAnswer
import kotlinx.android.synthetic.main.activity_main.linearLayoutMail
import kotlinx.android.synthetic.main.activity_main.linearLayoutMirrorDown
import kotlinx.android.synthetic.main.activity_main.linearLayoutMirrorDownAnswer
import kotlinx.android.synthetic.main.activity_main.linearLayoutNoAds
import kotlinx.android.synthetic.main.activity_main.linearLayoutNowWhat
import kotlinx.android.synthetic.main.activity_main.linearLayoutPhishing
import kotlinx.android.synthetic.main.activity_main.linearLayoutPhishingAnswer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answerMap = mapOf<View, View>(
            linearLayoutMirrorDown to linearLayoutMirrorDownAnswer,
            linearLayoutAddressBar to frameLayoutAddressBarAnswer,
            linearLayoutAlwaysMisclick to linearLayoutAlwaysMisclickAnswer,
            linearLayoutDifferentBrowser to linearLayoutDifferentBrowserAnswer,
            linearLayoutMail to frameLayoutMailAnswer,
            linearLayoutNoAds to frameLayoutNoAdsAnswer,
            linearLayoutPhishing to linearLayoutPhishingAnswer,
            linearLayoutNowWhat to frameLayoutNowWhatAnswer
        )

        val questionClickListener = View.OnClickListener { answerMap.get(it)?.toggleVisibility() }

        listOf<View>(
            linearLayoutMirrorDown,
            linearLayoutAddressBar,
            linearLayoutAlwaysMisclick,
            linearLayoutDifferentBrowser,
            linearLayoutMail,
            linearLayoutNoAds,
            linearLayoutPhishing,
            linearLayoutNowWhat)
            .forEach { it.setOnClickListener(questionClickListener) }

    }
}

fun View.toggleVisibility() {
    val newVisibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
    visibility = newVisibility
}