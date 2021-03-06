package com.example.eunbinletter.letter

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat

import androidx.drawerlayout.widget.DrawerLayout
import com.example.eunbinletter.FirstActivity
import com.example.eunbinletter.picture.PictureActivity
import com.example.eunbinletter.QuizMainActivity
import com.example.eunbinletter.R
import com.google.android.material.navigation.NavigationView

class LetterMainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var text : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lettermain)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val letter1 = findViewById<ImageView>(R.id.letter)
        val letter2 = findViewById<ImageView>(R.id.letter2)

        letter1.setColorFilter(Color.parseColor("#CD1039"))
        letter2.setColorFilter(Color.parseColor("#FF7200"))


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menupic)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        drawerLayout = findViewById(R.id.drawer_layout)

        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)

        letter1.setOnClickListener(){
            val intent = Intent(this, LetterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        letter2.setOnClickListener(){
            val intent2 = Intent(this, Letter2Activity::class.java)
            startActivity(intent2)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

    }

    // ?????? ?????? ????????? ?????? ?????? ??? ???????????? ??????
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // ????????? ?????? ?????? ????????? id ?????? ????????? ??????????????? ??????
        when(item!!.itemId){
            android.R.id.home->{
                // ????????? ?????? ????????? ??????????????? ????????? ??????
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    // ????????? ??? ????????? ?????? ????????? ???????????? ??????
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_picture){
            val picture = Intent(this, PictureActivity::class.java)
            startActivity(picture)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
//            Toast.makeText(this, "???????????? ???????????????", Toast.LENGTH_LONG).show()
        } else if(item.itemId == R.id.menu_letter) {
            val letter = Intent(this, LetterMainActivity::class.java)
            startActivity(letter)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
//            Toast.makeText(this, "???????????? ???????????????", Toast.LENGTH_LONG).show()
        } else if(item.itemId == R.id.menu_quiz) {
            val quiz = Intent(this, QuizMainActivity::class.java)
            startActivity(quiz)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        } else if(item.itemId == R.id.menu_home) {
            val home = Intent(this, FirstActivity::class.java)
            startActivity(home)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        return false
    }


}