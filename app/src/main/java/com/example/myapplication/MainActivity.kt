package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_share.setOnClickListener {
            var bottomSelectDialog:BottomSelectDialog= BottomSelectDialog()
            bottomSelectDialog.show(supportFragmentManager,"show")
        }
    }
}
