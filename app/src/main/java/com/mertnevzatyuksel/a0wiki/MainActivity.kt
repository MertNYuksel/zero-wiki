package com.mertnevzatyuksel.a0wiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.widget.AppCompatImageView
import kotlinx.android.synthetic.main.activity_main.frameLayoutAddressBarAnswer
import kotlinx.android.synthetic.main.activity_main.frameLayoutMailAnswer
import kotlinx.android.synthetic.main.activity_main.frameLayoutNoAdsAnswer
import kotlinx.android.synthetic.main.activity_main.frameLayoutNowWhatAnswer
import kotlinx.android.synthetic.main.activity_main.imageViewAddressBar
import kotlinx.android.synthetic.main.activity_main.imageViewAlwaysMisclick
import kotlinx.android.synthetic.main.activity_main.imageViewDifferentBrowser
import kotlinx.android.synthetic.main.activity_main.imageViewMail
import kotlinx.android.synthetic.main.activity_main.imageViewMirrorDown
import kotlinx.android.synthetic.main.activity_main.imageViewNoAds
import kotlinx.android.synthetic.main.activity_main.imageViewNowWhat
import kotlinx.android.synthetic.main.activity_main.imageViewPhishing
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

        val arrowMap = mapOf<View, AppCompatImageView>(
            linearLayoutMirrorDown to imageViewMirrorDown,
            linearLayoutAddressBar to imageViewAddressBar,
            linearLayoutAlwaysMisclick to imageViewAlwaysMisclick,
            linearLayoutDifferentBrowser to imageViewDifferentBrowser,
            linearLayoutMail to imageViewMail,
            linearLayoutNoAds to imageViewNoAds,
            linearLayoutPhishing to imageViewPhishing,
            linearLayoutNowWhat to imageViewNowWhat
        )

        val questionClickListener = View.OnClickListener {
            questionView ->
            answerMap.get(questionView)?.let { answerView ->
                answerView.toggleVisibility()
                arrowMap.get(questionView)?.setImageResource(getArrowDirectionFromViewVisibility(answerView.visibility))
            }
        }

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

    private fun getArrowDirectionFromViewVisibility(visibility: Int): Int {
        return if (visibility == View.VISIBLE) R.drawable.ic_arrow_drop_up_black_24dp else R.drawable.ic_arrow_drop_down_black_24dp
    }
}

fun View.toggleVisibility() {
    val newVisibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
    visibility = newVisibility
}