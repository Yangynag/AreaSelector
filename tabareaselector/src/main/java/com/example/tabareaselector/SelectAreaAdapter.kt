package com.example.myapplication

import android.content.Context
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView.BufferType
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.AreaAdapter.ListItemClickListener
import com.example.tabareaselector.SelectAreaLayout
import kotlinx.android.synthetic.main.select_area_layout.view.*

class SelectAreaAdapter<T> : ITabInterface<T> {
    lateinit var mSelectAreaLayout: SelectAreaLayout<T>
    lateinit var mITabClickListener: ITabClickListener
    lateinit var mAreaAdapter: AreaAdapter<T>
    lateinit var context: Context
    lateinit var layoutParams: LinearLayout.LayoutParams
    var tabIndex: Int = -1
    var maxtabNum: Int = 3
    fun attachLayout(
        mSelectAreaLayout: SelectAreaLayout<T>,
        context: Context,
        mITabClickListener: ITabClickListener
    ) {
        this.mSelectAreaLayout = mSelectAreaLayout
        this.mITabClickListener = mITabClickListener
        this.mAreaAdapter = AreaAdapter<T>(mListItemClickListener)
        this.context = context
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        layoutParams.gravity = Gravity.CENTER
        mSelectAreaLayout.rcv.layoutManager = LinearLayoutManager(this.context)
        mSelectAreaLayout.rcv.adapter = this.mAreaAdapter
    }


    var mListItemClickListener: ListItemClickListener<T> =
        object : ListItemClickListener<T> {
            override fun refreshTabLayout(t: T) {

                var currentTab: Tab = mSelectAreaLayout.lr_select.getChildAt(tabIndex) as Tab
                currentTab.setText(t.toString())
                currentTab.tabName=t.toString()
                currentTab.setUnSelected()
                if (tabIndex < maxtabNum - 1) {
                    addTab(t)
                    currentTab = mSelectAreaLayout.lr_select.getChildAt(tabIndex) as Tab
                    currentTab.performClick()
                } else {
                    var selectedTabs: ArrayList<Tab> = ArrayList()
                    if (tabIndex == maxtabNum - 1) {
                        for (index in 0 until maxtabNum) {
                            selectedTabs.add(mSelectAreaLayout.lr_select.getChildAt(index) as Tab)
                        }
                        mITabClickListener.completeSelect(selectedTabs)
                    }

                }
            }
        }

    override fun addTab(t: T) {
        tabIndex++;
        var tab: Tab = Tab(context)
        tab.index = tabIndex
        tab.tabSelected = true
        tab.tabName = t.toString()
        tab.setText("请选择", BufferType.NORMAL)
        tab.setPadding(0, 0, 15, 0)
        tab.setOnClickListener {
            this.mITabClickListener.requestAreaList(tab)
        }
        mSelectAreaLayout.lr_select.addView(tab, layoutParams)
    }

    interface ITabClickListener {
        fun requestAreaList(addTab: Tab)

        fun completeSelect(tabLists: ArrayList<Tab>)
    }

    override fun refreshAreaList(list: ArrayList<T>) {
        this.mAreaAdapter.refreshTabList(list)
    }

}