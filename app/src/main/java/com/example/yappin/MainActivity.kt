package com.example.yappin

import android.R
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
import com.example.yappin.ui.theme.YappinTheme
//import androidx.appcompat.app.AppCompatActivity
import com.example.yappin.databinding.ActivityMainBinding
import com.example.yappin.MyDatabaseHelper
import android.util.Log

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //start
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.textView.text = "Hello, World!"
       // val db = Database()
        try {
            val dbHelper = MyDatabaseHelper(this)
            val db = dbHelper.writableDatabase
            Log.d("DatabaseConnection", "Database connected successfully.")
        } catch (e: Exception) {
            Log.e("DatabaseConnection", "Error connecting to database: ${e.message}")
        }
         //end
        enableEdgeToEdge()
        setContent {
            YappinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Andro",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YappinTheme {
        Greeting("Andy")
    }
}