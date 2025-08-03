package com.elianan.teller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.elianan.teller.ui.layout.HomePage
import com.elianan.teller.ui.layout.HomePager
import com.elianan.teller.ui.layout.MainScaffold
import com.elianan.teller.ui.nav.TellerHost
import com.elianan.teller.ui.theme.TellerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TellerTheme {
                MainScaffold(
                    onOptionsClick = {},
                    onNavClick = {},
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->


                    val navController = rememberNavController()


                    TellerHost(navController, innerPadding)



                }




            }
        }
    }
}

