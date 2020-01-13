package com.tsnanh.calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

        navController = findNavController(R.id.navHost)

        val appBarConfig = AppBarConfiguration(
                setOf(
                        R.id.materialCalculatorFragment, R.id.IOSCalculatorFragment,
                        R.id.customCalculatorFragment
                )
        )

        setupActionBarWithNavController(navController, appBarConfig)
        bottomNavView.setupWithNavController(navController)
        bottomNavView.setOnNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_material -> navController.navigate(R.id.materialCalculatorFragment)
            R.id.navigation_ios -> navController.navigate(R.id.IOSCalculatorFragment)
            R.id.navigation_custom -> navController.navigate(R.id.customCalculatorFragment)
        }
        return true
    }
}
