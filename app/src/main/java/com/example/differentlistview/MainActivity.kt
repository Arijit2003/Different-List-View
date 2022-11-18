package com.example.differentlistview

import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1:Button=findViewById(R.id.button)
        val button2:Button=findViewById(R.id.button2)
        val imageSlider:ImageSlider=findViewById(R.id.imgSlide)
       drawerLayout=findViewById(R.id.drawerLayout)
        val navView:NavigationView=findViewById(R.id.nav_drawer)

        var toolbar:androidx.appcompat.widget.Toolbar=findViewById(R.id.toolbar)

        var imageList:ArrayList<SlideModel> = arrayListOf()
        imageList.add(SlideModel(R.drawable.krishna))
        imageList.add(SlideModel(R.drawable.radhe_krishna))
        imageList.add(SlideModel(R.drawable.lakshmi_narayan))
        imageList.add(SlideModel(R.drawable.sita_ram))
        imageList.add(SlideModel(R.drawable.gauri_sankar))
        imageList.add(SlideModel(R.drawable.hanumanji))
        imageList.add(SlideModel(R.drawable.ganesha))
        imageList.add(SlideModel(R.drawable.kartikeya))
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        button1.setOnClickListener(){
            val intent:Intent=Intent(this,NormalList::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener(){
            val intent:Intent=Intent(this,CustomListView::class.java)
            startActivity(intent)
        }
        setSupportActionBar(toolbar)
        /*supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)*/
        /*navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener{
            fun NavigationView.OnNavigationItemSelectedListener
        })*/

        navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item: MenuItem ->Boolean
            when(item.itemId){
                R.id.about_us->{
                    Toast.makeText(this,"Clicked About Us ",Toast.LENGTH_SHORT).show()
                }
                R.id.share->{
                    Toast.makeText(this,"Clicked Share",Toast.LENGTH_SHORT).show()
                }
            }
        true
        })



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater:MenuInflater=getMenuInflater()
        menuInflater.inflate(R.menu.menu_main_activity,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.NormalList->{
                Toast.makeText(this,"Normal List clicked",Toast.LENGTH_SHORT).show()
                val intent:Intent=Intent(this,NormalList::class.java)
                startActivity(intent)
            }
            R.id.CustomList->{
                Toast.makeText(this,"Custom List clicked",Toast.LENGTH_SHORT).show()
                val intent:Intent=Intent(this,CustomListView::class.java)
                startActivity(intent)
            }
            android.R.id.home->{
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return true

    }
}