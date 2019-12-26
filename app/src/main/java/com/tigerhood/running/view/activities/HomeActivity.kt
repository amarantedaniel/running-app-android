package com.tigerhood.running.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.tigerhood.running.R


class HomeActivity : AppCompatActivity() {

    private val navigationController by lazy { findNavController(R.id.navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupActionBarWithNavController(navigationController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigationController.navigateUp()
    }
}
