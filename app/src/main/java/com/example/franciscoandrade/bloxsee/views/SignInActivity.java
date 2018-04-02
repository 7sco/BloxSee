package com.example.franciscoandrade.bloxsee.views;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.franciscoandrade.bloxsee.R;

public class SignInActivity extends AppCompatActivity  {

    private android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
    private StudentSignInFragment studentSignInFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        studentSignInFragment = new StudentSignInFragment();
        fragmentManager.beginTransaction().replace(R.id.loginContainer, studentSignInFragment).commit();

// don't delete my intent please
//        Intent intent = new Intent(this, BlocklyActivity.class);
//        startActivity(intent);


    }
}
