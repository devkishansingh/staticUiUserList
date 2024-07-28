package com.devkishan.staticuiuserlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import com.devkishan.staticuiuserlist.ui.theme.StaticUiUserListTheme
import userList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StaticUiUserListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Spacer(innerPadding)
                    userList()
                }
            }
        }
    }
}
