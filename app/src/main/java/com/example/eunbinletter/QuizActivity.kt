package com.example.eunbinletter

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.view.View.GONE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.eunbinletter.letter.LetterMainActivity
import com.example.eunbinletter.picture.PictureActivity
import com.example.eunbinletter.sing.SingActivity
import com.google.android.material.navigation.NavigationView

class QuizActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var shuffle: TextView
    lateinit var remainTime: TextView
    lateinit var result: EditText
    lateinit var submit: Button
    lateinit var list: MutableList<String>
    lateinit var resultList: MutableList<String>
    lateinit var timer:CountDownTimer
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        list = mutableListOf(
            "도환이가 가장 좋아하는 음식은??",
            "도환이가 가장 좋아하는 발라드 가수는??",
            "그럼 래퍼는??",
            "도환이의 휴대폰 번호는??(- 빼고)",
            "도환이의 혈액형은???",
            "도환이가 태어난 시각은 몇시 인가??",
            "우리가 사귄 날짜는 몇월 몇일인가??",
            "도환이가 하는 일은 무엇인가??",
            "은빈이가 가장 사랑하는 사람은??",
            "도환이가 가장 사랑하는 사람은??",
        )

        resultList = mutableListOf(
            "떡볶이",
            "임한별",
            "조광일",
            "01047240694",
            "B형",
            "오전 8시",
            "12월 31일",
            "개발자",
            "도환이",
            "은빈이",
        )

        shuffle = findViewById(R.id.shuffle)
        remainTime = findViewById(R.id.time)
        result = findViewById(R.id.result)
        submit = findViewById(R.id.submit)

        shuffle.text = list.removeAt(0)

        timer = object:CountDownTimer(120000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                remainTime.text = ""+millisUntilFinished/1000+"초 남음"
            }

            override fun onFinish() {
                remainTime.text = "시간 종료"
                shuffle.text = "성공 개수 : "+count+""
                submit.visibility = GONE
                result.visibility = GONE
            }
        }

        timer.start()

        submit.setOnClickListener(){
            val value = result.text.toString()
            result.setText(null)

            if(value == ""){
                Toast.makeText(this, "정답을 입력하세요.", Toast.LENGTH_LONG).show()
            } else{
                for(i in resultList){
                    if(i == value){
                        count++
                    }
                }

                if(list.isEmpty()){
                    shuffle.text = "성공 개수 : "+count+""
                    submit.visibility = GONE
                    result.visibility = GONE
                    remainTime.visibility = GONE
                } else{
                    shuffle.text = list.removeAt(0)

                }

            }

        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menupic)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        drawerLayout = findViewById(R.id.drawer_layout)

        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)
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