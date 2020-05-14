package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.blankj.utilcode.util.ScreenUtils
import com.example.tabareaselector.R
import com.example.tabareaselector.SelectAreaLayout
import kotlinx.android.synthetic.main.dialog_bottom_sheet.view.*

class BottomSelectDialog : DialogFragment() {
    private lateinit var mRoot: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!this::mRoot.isInitialized) {
            mRoot = inflater.inflate(R.layout.dialog_bottom_sheet, container, false)
        }
        return mRoot
    }

    override fun onStart() {
        super.onStart()

        val win = dialog!!.window
        // 一定要设置Background，如果不设置，window属性设置无效
        // 一定要设置Background，如果不设置，window属性设置无效
        win!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dm = DisplayMetrics()
        activity!!.windowManager.defaultDisplay.getMetrics(dm)

        val params = win.attributes
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ScreenUtils.getScreenHeight() * 5 / 8
        params.gravity = Gravity.BOTTOM
        win.attributes = params
    }

    lateinit var selectAreaAdapter: SelectAreaAdapter<TabEntity>;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        selectAreaAdapter = SelectAreaAdapter<TabEntity>()
        context?.let {
            selectAreaAdapter.attachLayout(
                mRoot.sal as SelectAreaLayout<TabEntity>,
                it, mITabClickListener
            )
        }
        var mTabEntity: TabEntity = TabEntity()
        mTabEntity.tabName = "全国"
        selectAreaAdapter.addTab(mTabEntity)
    }

    var textaaaa: String = ""

    var mITabClickListener: SelectAreaAdapter.ITabClickListener = object :
        SelectAreaAdapter.ITabClickListener {
        override fun requestAreaList(addTab: Tab) {
            refreshAreaList(addTab)
            selectAreaAdapter.refreshAreaList(list)
        }

        override fun completeSelect(tabLists: ArrayList<Tab>) {
            for (index in 0 until tabLists.size) {
                textaaaa = textaaaa + tabLists[index].tabName
            }
            Log.e(
                "completeSelect", textaaaa
            )
            dismissAllowingStateLoss()
        }

    }
    var list: ArrayList<TabEntity> = ArrayList()


    private fun refreshAreaList(addTab: Tab) {
        list.clear()
        if (addTab.index == 0) {
            var tabEntity01: TabEntity = TabEntity()
            tabEntity01.tabName = "全国"
            list.add(tabEntity01)
        } else if (addTab.tabName == "全国") {
            var tabEntity10: TabEntity = TabEntity()
            tabEntity10.tabName = "江苏"
            var tabEntity11: TabEntity = TabEntity()
            tabEntity11.tabName = "浙江"
            var tabEntity12: TabEntity = TabEntity()
            tabEntity12.tabName = "上海"
            var tabEntity13: TabEntity = TabEntity()
            tabEntity13.tabName = "北京"
            list.add(tabEntity10)
            list.add(tabEntity11)
            list.add(tabEntity12)
            list.add(tabEntity13)
        } else if (addTab.tabName == "江苏") {
            var tabEntity100: TabEntity = TabEntity()
            var tabEntity101: TabEntity = TabEntity()
            var tabEntity102: TabEntity = TabEntity()
            var tabEntity103: TabEntity = TabEntity()
            var tabEntity104: TabEntity = TabEntity()
            var tabEntity105: TabEntity = TabEntity()
            var tabEntity106: TabEntity = TabEntity()
            var tabEntity107: TabEntity = TabEntity()
            var tabEntity108: TabEntity = TabEntity()
            var tabEntity109: TabEntity = TabEntity()
            var tabEntity1010: TabEntity = TabEntity()
            var tabEntity1011: TabEntity = TabEntity()
            var tabEntity1012: TabEntity = TabEntity()

            tabEntity101.tabName = "南京"
            tabEntity102.tabName = "无锡"
            tabEntity103.tabName = "徐州"
            tabEntity104.tabName = "苏州"
            tabEntity105.tabName = "南通"
            tabEntity106.tabName = "连云港"
            tabEntity107.tabName = "淮安"
            tabEntity108.tabName = "盐城"
            tabEntity109.tabName = "扬州"
            tabEntity1010.tabName = "镇江"
            tabEntity1011.tabName = "泰州"
            tabEntity1012.tabName = "宿迁"
            list.add(tabEntity101)
            list.add(tabEntity102)
            list.add(tabEntity103)
            list.add(tabEntity104)
            list.add(tabEntity105)
            list.add(tabEntity106)
            list.add(tabEntity107)
            list.add(tabEntity108)
            list.add(tabEntity109)
            list.add(tabEntity1010)
            list.add(tabEntity1011)
            list.add(tabEntity1012)
        }

    }
}