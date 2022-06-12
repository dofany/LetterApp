package com.example.eunbinletter

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.eunbinletter.letter.LetterMainActivity
import com.example.eunbinletter.picture.PictureActivity
import com.example.eunbinletter.sing.SingActivity
import com.google.android.material.navigation.NavigationView

class QuizMainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizmain)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menupic)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        drawerLayout = findViewById(R.id.drawer_layout)

        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)

        val titleImage = findViewById<ImageView>(R.id.titleImage)
        titleImage.setColorFilter(Color.parseColor("#FF82FF"))
        titleImage.setOnClickListener(){
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // 클릭한 툴바 메뉴 아이템 id 마다 다르게 실행하도록 설정
        when(item!!.itemId){
            android.R.id.home->{
                // 햄버거 버튼 클릭시 네비게이션 드로어 열기
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }



    // 드로어 내 아이템 클릭 이벤트 처리하는 함수
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_picture ){
            val picture = Intent(this, PictureActivity::class.java)
            startActivity(picture)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
//            Toast.makeText(this, "업데이트 예정중ㅠㅠ", Toast.LENGTH_LONG).show()
        } else if(item.itemId == R.id.menu_letter) {
            val letter = Intent(this, LetterMainActivity::class.java)
            startActivity(letter)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
//            Toast.makeText(this, "업데이트 예정중ㅠㅠ", Toast.LENGTH_LONG).show()
        } else if(item.itemId == R.id.menu_quiz) {
            val quiz = Intent(this, QuizMainActivity::class.java)
            startActivity(quiz)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        } else if(item.itemId == R.id.menu_home) {
            val home = Intent(this, FirstActivity::class.java)
            startActivity(home)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        } else if(item.itemId == R.id.menu_sing) {
            val sing = Intent(this, SingActivity::class.java)
            startActivity(sing)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }

        return false
    }


}