package com.express.desafio02

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.express.desafio02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var flLoading: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        setNavigationGraph()
        setBindings()
        this.getWindow()
            .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private fun setBindings() {
        flLoading = findViewById(R.id.flLoading)
    }

    private fun setNavigationGraph() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.container_main) as NavHostFragment

        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        navGraph.setStartDestination(R.id.HomeFragment)
        navController.graph = navGraph
    }

    fun showLoading(show: Boolean) {
        flLoading.visibility = if (show) View.VISIBLE else View.GONE
    }

}