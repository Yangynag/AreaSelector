package com.example.tabareaselector

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.myapplication.SelectAreaAdapter
import com.example.myapplication.TabEntity

class SelectAreaLayout<T> @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    var mContext: Context

    init {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.select_area_layout, this, true)
    }
}