package hoods.com.jettimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jettimer.ui.theme.JetTimerTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTimerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetTimerApp()
                }
            }
        }

    }


    @Composable
    fun JetTimerApp() {
        val currentTime by viewModel.currentTime.collectAsState()
        val isRunning by viewModel.isTimerRunning.collectAsState()
        Timer(
            currentTime = currentTime,
            isRunning = isRunning,
            onStart = {
                viewModel.startTimer()
            },
            onRestart = {
                viewModel.restartTimer()
            }
        )
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
    JetTimerTheme {
        Greeting("Android")
    }
}