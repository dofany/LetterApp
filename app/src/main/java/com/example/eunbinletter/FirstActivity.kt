package com.example.eunbinletter

import android.content.Intent
import android.graphics.Picture
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class FirstActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val anim = AnimationUtils.loadAnimation(this,R.anim.alpha)

        findViewById<ImageView>(R.id.imageMenu).setOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START)
        }
        // 네비게이션 드로어 생성
        drawerLayout = findViewById(R.id.drawer_layout)

        // 네비게이션 드로어 내에있는 화면의 이벤트를 처리하기 위해 생성
        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this) //navigation 리스너

        text = findViewById(R.id.shortLetter)
        text.startAnimation(anim)

    }


    // 드로어 내 아이템 클릭 이벤트 처리하는 함수
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_picture ){
            val picture = Intent(this, PictureActivity::class.java)
            startActivity(picture)
        } else if(item.itemId == R.id.menu_letter) {
            val letter = Intent(this, LetterActivity::class.java)
            startActivity(letter)
        } else if(item.itemId == R.id.menu_quiz) {
            val quiz = Intent(this, QuizActivity::class.java)
            startActivity(quiz)
        } else if(item.itemId == R.id.menu_home) {
            val home = Intent(this, FirstActivity::class.java)
            startActivity(home)
        }

        return false
    }


}