package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView

class Tab @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {
    var index: Int = 0
    private var TextSelectedColor: Int = Color.parseColor("#347eff")
    private var TextEmptyColor = Color.parseColor("#666666")
    var tabSelected: Boolean = false
    var tab: Boolean = false
    var tabName: String = ""
    var tabShowName: String = ""

    init {
        setTextSize(14F)
        gravity = Gravity.CENTER
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        if (tabSelected) {
            setTextColor(TextSelectedColor)
        } else {
            setTextColor(TextEmptyColor)
        }
        super.setText(text, type)
    }

    fun setUnSelected() {
        tabSelected = false
        setTextColor(TextEmptyColor)
    }
}