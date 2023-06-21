package hoods.com.jettimer


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Timer(
    currentTime: Long,
    isRunning: Boolean,
    onStart: () -> Unit,
    onRestart: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Row(modifier = Modifier.align(Alignment.BottomCenter)) {
            Button(onClick = onStart) {
                Text(text = "Start")
            }
            Spacer(modifier = Modifier.size(8.dp))
            Button(onClick = onRestart) {
                Text(text = "Restart")
            }
        }
        Text(text = getFormattedTime(currentTime))
    }


}