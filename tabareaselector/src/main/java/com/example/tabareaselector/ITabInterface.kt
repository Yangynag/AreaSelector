package com.example.myapplication

interface ITabInterface<T> {
    fun addTab(t:T )
    fun refreshAreaList(list: ArrayList<T>)
}