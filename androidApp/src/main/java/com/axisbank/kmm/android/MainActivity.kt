package com.axisbank.kmm.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import com.axisbank.kmm.EventListener
import com.axisbank.kmm.NavigationMain
import com.axisbank.kmm.Shared

class MainActivity : ComponentActivity(), EventListener {
    var navController: NavHostController? = null
    val shared = Shared()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationMain()
        }

        /*    navController = rememberNavController()
            NavHost(navController!!, startDestination = AppNav.Login.route) {
                composable(AppNav.Login.route) {
                    App(shared)
                }
                composable(AppNav.Dashboard.route) {
                    DashboardScreen()
                }
            }

            shared.registerListener(this)
        }*/
    }

    override fun onEventOccurred(data: String) {
        Log.e("AndroidPlatform", data)
        navController!!.navigate(AppNav.Dashboard.route)
    }

}



