package com.example.jymcompose.ui.screens.navigation.botomnavigation

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
@Preview
@Composable
fun MyBottomNavigation(navController: NavController = rememberNavController() ) {
   // fun MyBottomNavigation() {
    //val navController = rememberNavController()
    val listScreens = listOf(
        BottomItem.MyWorkout,
        BottomItem.DefaultWorkouts,
        BottomItem.Profile
    )

    BottomNavigation() {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route
        Log.d("currentRout", " $currentRout")
        val context = LocalContext.current
        listScreens.forEach { item ->
            BottomNavigationItem(modifier = Modifier.background(Color.White),
                selected = currentRout == context.resources.getString(item.rout),
                onClick = { navController.navigate(context.resources.getString(item.rout)) },
                label = {
                    Text(text = stringResource(id = item.title), fontSize = 10.sp)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = stringResource(
                            id = item.title
                        )
                    )
                },

                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Red
            )
        }
    }
}