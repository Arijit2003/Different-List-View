package com.example.differentlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*

class CustomListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)
        val searchView:SearchView=findViewById(R.id.searchView)
        val listView:ListView=findViewById(R.id.customList)
        val arrayList:ArrayList<GOD> = arrayListOf()
        arrayList.add(GOD(R.drawable.radhe_krishna,"RadheKrishna"))
        arrayList.add(GOD(R.drawable.sita_ram,"SitaRam"))
        arrayList.add(GOD(R.drawable.lakshmi_narayan,"LaksmiNarayan"))
        arrayList.add(GOD(R.drawable.gauri_sankar,"GauriSankar"))
        arrayList.add(GOD(R.drawable.bramha_saraswati,"BramhaSaraswati"))
        arrayList.add(GOD(R.drawable.hanumanji,"Ram Bhakt Hanuman"))
        arrayList.add(GOD(R.drawable.kartikeya,"Kartikeya"))
        arrayList.add(GOD(R.drawable.ganesha,"Ganesha"))
        val newArrayAdapter=GodArrayAdapter(this,R.layout.custom_list_sample,arrayList)
        listView.adapter=newArrayAdapter
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                var ArrayList:ArrayList <GOD> = arrayListOf()
                for(i in arrayList){
                    if(i.name.lowercase().contains(newText.toString().lowercase()) ){
                            ArrayList.add(i)
                    }
                }
                var aa=GodArrayAdapter(this@CustomListView,R.layout.custom_list_sample,ArrayList)
                listView.adapter=aa
                return false
            }
        })



        listView.setOnItemClickListener { parent, view, position, id ->
            val element:GOD=listView.getItemAtPosition(position) as GOD
            Toast.makeText(this,"${element.name}",Toast.LENGTH_SHORT).show()
        }

    }
}