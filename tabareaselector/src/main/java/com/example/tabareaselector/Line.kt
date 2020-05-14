package com.example.myapplication

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.ColorUtils
import com.example.tabareaselector.R


class Line @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var tabAmount: Float = 0.0f
    private lateinit var indicator: View
    private val sum = 3
    private var oldIndex = 0
    private var nowIndex = 0
    init {
        orientation = HORIZONTAL
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT, 6
        )
        weightSum = tabAmount
        indicator = View(context)
        indicator.setLayoutParams(
            LayoutParams(
                0,
                LayoutParams.MATCH_PARENT,
                1.0f
            )
        )
        indicator.setBackgroundColor(ColorUtils.getColor(R.color.colorBlue))
        addView(indicator)
    }

    fun setIndex(index: Int) {
        val onceWidth: Int = width / sum
        this.nowIndex = index
        var animator:ObjectAnimator=ObjectAnimator.ofFloat(indicator,
            "translationX", indicator.translationX
            )


    }
}


