package com.tigerhood.running.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tigerhood.running.HomeContract
import com.tigerhood.running.R

class HomeActivity : AppCompatActivity(), HomeContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}
