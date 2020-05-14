package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.tabareaselector.R
import kotlinx.android.synthetic.main.item_area.view.*

class AreaAdapter<T>(mListItemClickListener: ListItemClickListener<T>) : Adapter<AreaAdapter.MyHolder>(),
    View.OnClickListener {
    private var mListItemClickListener: ListItemClickListener<T> = mListItemClickListener

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


    private var areaList = arrayListOf<T>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_area,
            parent,
            false
        )
        itemView.setOnClickListener(this)
        return MyHolder(
            itemView
        )
    }

    override fun getItemCount(): Int {
        return areaList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.itemView.tag = position
        holder.itemView.tv_text.setText(areaList[position].toString())
    }

    fun refreshTabList(areaList: ArrayList<T>) {
        this.areaList = areaList;
        notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        this.mListItemClickListener.refreshTabLayout(this.areaList[v?.tag as Int])
    }

    interface ListItemClickListener<T> {
        fun refreshTabLayout(t: T)
    }
}