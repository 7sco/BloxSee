package com.example.franciscoandrade.bloxsee.views.teacher;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.PorterDuff;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.franciscoandrade.bloxsee.R;
import com.example.franciscoandrade.bloxsee.controller.teacher.PagerAdapterTeacher;
import com.example.franciscoandrade.bloxsee.model.Progress;
import com.example.franciscoandrade.bloxsee.views.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TeacherMainPageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener , ListenerProgress{
    private final String TAG = "TEACHER_EMAIL: ";
    private final String TAG_OC = "TOOLBAR_DISPLAY";
    private Toolbar topToolbar;
    private ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    MenuItem prevMenuItem;

    ProgressFragment progressFragment;
    QuestionsFragment questionsFragment;
    RosterFragment rosterFragment;
    PagerAdapterTeacher adapter;

    String actualPosition="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_page);

        setupToolbar();
        getTeacherInfo();

        Log.d(TAG, "onCreate: " + getTitle());

        viewPager = findViewById(R.id.view_pager_teacher);

        bottomNavigationView = findViewById(R.id.bottom_nav_teacher);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.roster_teacher:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.progress_teacher:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.questions_teacher:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);

                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.teacher_signout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.signout_teacher){
            Intent intent = new Intent(TeacherMainPageActivity.this, SignInActivity.class);
            startActivity(intent);
        }
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new PagerAdapterTeacher(getSupportFragmentManager());
        rosterFragment = new RosterFragment();
        progressFragment = new ProgressFragment();
        questionsFragment = new QuestionsFragment();
        adapter.addFragment(rosterFragment);
        adapter.addFragment(progressFragment);
        adapter.addFragment(questionsFragment);
        viewPager.setAdapter(adapter);
    }

    private void getTeacherInfo() {
        SharedPreferences prefs = getSharedPreferences("teacher_info",
                MODE_PRIVATE);
        String string = prefs.getString("teacher_email",
                "");
        Log.d(TAG, "getTeacherInfo: " + string);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {
        Log.d("PAGER==", "onPageSelected: "+position);

        actualPosition=String.valueOf(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void closeFragment() {

        rosterFragment.closeFragment();
    }

    @Override
    public void closeView() {
        rosterFragment.closeFragment();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(actualPosition.equals("1")){
            rosterFragment.showFloatingBtn();
        }
    }

    public void setupToolbar(){
        topToolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(topToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Admin Email");
        }
    }
}
