package com.example.differentlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class NormalList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_list)
        val listView:ListView=findViewById(R.id.listview1)
        val GodList:ArrayList<String> = arrayListOf("RadheKrishna","SitaRam","LakshmiNarayan","ParvatiShiv","Kartikey","Ganesha","Narad")
        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this,R.layout.normal_list_sample,R.id.textView,GodList)
        listView.adapter=arrayAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val element:String=listView.getItemAtPosition(position) as String
            Toast.makeText(this,element,Toast.LENGTH_LONG).show()
        }
    }
}