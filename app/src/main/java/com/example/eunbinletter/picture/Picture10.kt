package com.example.eunbinletter.picture

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
import com.google.android.material.navigation.NavigationView

class Picture10 : AppCompatActivity(), FragmentManager.OnBackStackChangedListener,NavigationView.OnNavigationItemSelectedListener{
    var isShowingBackLayout = false
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.picture10_flip)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameLayout, Picture10_front())
                .commit()
        } else {
            isShowingBackLayout = supportFragmentManager.backStackEntryCount > 0
        }

        supportFragmentManager.addOnBackStackChangedListener(this);

        val study_flip_container = findViewById(R.id.frameLayout) as FrameLayout
        study_flip_container.setOnClickListener {
            flipCard()
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

    override fun onBackStackChanged() {
        isShowingBackLayout = (supportFragmentManager.getBackStackEntryCount() > 0);
    }

    private fun flipCard() {
        if (isShowingBackLayout) {
            supportFragmentManager.popBackStack();
            return;
        }
        isShowingBackLayout = true;
        supportFragmentManager.beginTransaction()
            //????????? ???????????????
            .setCustomAnimations(
                R.anim.cardflip_right_in, R.anim.cardflip_right_out,
                R.anim.cardflip_left_in, R.anim.cardflip_left_out)
            // ???????????? ??????
            .replace(R.id.frameLayout, Picture10_back())
            // ???????????? ????????? ????????? ?????????
            .addToBackStack(null)
            .commit();
    }

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
        } else if(item.itemId == R.id.menu_sing) {
            val sing = Intent(this, FirstActivity::class.java)
            startActivity(sing)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        return false
    }

}