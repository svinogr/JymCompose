package com.example.jymcompose.ui.screens.navigation.botomnavigation

import android.content.Context
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jymcompose.R
import com.example.jymcompose.ui.screens.ProfileScreen.ProfileScreen
import com.example.jymcompose.ui.screens.defaultscreen.DefaultWorkoutsScreen
import com.example.jymcompose.ui.screens.myworkouts.MyWorkoutsScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    val context = LocalContext.current
   // val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = stringResource(id = R.string.my_workouts_rout)
    ) {

        composable(route = context.getString(R.string.my_workouts_rout)) {
            MyWorkoutsScreen()
        }

        composable(route =context.getString(R.string.default_workouts_rout)) {
            DefaultWorkoutsScreen()
        }

        composable(route = context.getString(R.string.profile_rout)) {
            Log.d("context", context.getString(R.string.profile_rout))
            ProfileScreen()
        }
    }

}