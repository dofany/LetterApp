package com.example.eunbinletter.sing

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import com.example.eunbinletter.FirstActivity
import com.example.eunbinletter.QuizMainActivity
import com.example.eunbinletter.R
import com.example.eunbinletter.letter.LetterMainActivity
import com.example.eunbinletter.picture.PictureActivity
import com.google.android.material.navigation.NavigationView

class Balade : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    var isShowingBackLayout = false
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.picture21_flip)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menupic)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        drawerLayout = findViewById(R.id.drawer_layout)

        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)

    }


    // 드로어 내 아이템 클릭 이벤트 처리하는 함수
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_picture){
            val picture = Intent(this, PictureActivity::class.java)
            startActivity(picture)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
//            Toast.makeText(this, "업데이트 예정중ㅠㅠ", Toast.LENGTH_LONG).show()
        } else if(item.itemId == R.id.menu_letter) {
            val letter = Intent(this, LetterMainActivity::class.java)
            startActivity(letter)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
//            Toast.makeText(this, "업데이트 예정중ㅠㅠ", Toast.LENGTH_LONG).show()
        } else if(item.itemId == R.id.menu_quiz) {
            val quiz = Intent(this, QuizMainActivity::class.java)
            startActivity(quiz)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        } else if(item.itemId == R.id.menu_home) {
            val home = Intent(this, FirstActivity::class.java)
            startActivity(home)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        } else if(item.itemId == R.id.menu_sing) {
            val sing = Intent(this, FirstActivity::class.java)
            startActivity(sing)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        return false
    }

}