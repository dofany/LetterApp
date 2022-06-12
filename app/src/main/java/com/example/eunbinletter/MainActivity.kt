package com.example.eunbinletter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var actionBar : ActionBar?
        actionBar = supportActionBar;
        actionBar?.hide()

        val edit_id = findViewById<TextView>(R.id.edit_id) // 아이디 입력 폼
        val edit_pw = findViewById<TextView>(R.id.edit_pw) // 비밀번호 입력 폼
        val btn_login = findViewById<Button>(R.id.btn_login) // 로그인 버튼

        btn_login.setOnClickListener {
            val id = edit_id.text.toString()
            val pw = edit_pw.text.toString()

            // 로그인 정합성 검사
            if (id == "eunbin" && pw == "1231")
            {
                // 로그인에 성공하는 경우
                val intent = Intent(this, FirstActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("pw", pw)
                startActivity(intent)
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

            } else if(id == "" || pw == ""){
                Toast.makeText(this, "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show()
            } else {
                // 로그인에 실패하는 경우
                Toast.makeText(this, "은빈이만 들어갈수 있뜸", Toast.LENGTH_LONG).show()
            }

        }
    }
}