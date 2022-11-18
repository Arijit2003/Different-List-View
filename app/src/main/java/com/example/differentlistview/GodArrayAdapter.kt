package com.example.differentlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView

class GodArrayAdapter(var content: CustomListView, var resource:Int, var arrayList:ArrayList<GOD>):ArrayAdapter<GOD>(content, resource,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater=LayoutInflater.from(content)
        val view:View=layoutInflater.inflate(resource,null)
        val imageView:ImageView=view.findViewById(R.id.imaeView)
        val textView:TextView=view.findViewById(R.id.textView2)
        var god:GOD=arrayList[position]
        imageView.setImageResource(god.img)
        textView.text=god.name
        return view
    }
}