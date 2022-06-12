package com.example.eunbinletter.picture

import android.content.Intent
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat

import androidx.drawerlayout.widget.DrawerLayout
import com.example.eunbinletter.*
import com.example.eunbinletter.letter.LetterMainActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_picture.*

class PictureActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menupic)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        drawerLayout = findViewById(R.id.drawer_layout)

        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)



        val list = ArrayList<PictureData>()
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "은빈아", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "너무나도", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "사랑하는", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "내 사랑♥", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "하나씩", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "열어보면", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "우리들의", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "추억이", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "열릴거야", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "우리", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "여행도", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "자주 다니고", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "많이", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "놀러 다니자", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "그러니까", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "나", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "차 사주게 해주면", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "좋을거같애♥", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "그렇게 해줄꺼지??♥", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "폴라로이드 사서", ""))
        list.add(PictureData(ContextCompat.getDrawable(this, R.drawable.heart)!!, "앨범도 만들자", ""))


        val adapter = RecyclerPictureAdapter(list)
        lstUser.adapter = adapter

    }

    // 툴바 메뉴 버튼이 클릭 됐을 때 실행하는 함수
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