package com.ali.dev.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ali.dev.tictactoe.ui.theme.TicTacToeTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    TicTacToeMenu()
                }
            }
        }
    }

    @Preview
    @Composable
    fun TicTacToeMenu() {
        val buttonPadding = 10.dp
        val textPadding = 5.dp
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxHeight()
        ) {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Tic Tac Toe",
                        fontWeight = FontWeight.Bold
                    )
                },
            )
            Column(Modifier.padding(20.dp)) {
                Button(
                    onClick = { startGameWithAi() },
                    modifier = Modifier.padding(buttonPadding)
                ) {
                    Text(text = "PLAY WITH AI", Modifier.padding(textPadding))
                }
                Button(
                    onClick = { startGame() },
                    modifier = Modifier.padding(buttonPadding)
                ) {
                    Text(text = " PLAY ALONE ", Modifier.padding(textPadding))
                }
            }
        }
    }

    private fun startGame() {
        startActivity(Intent(this, GameActivity::class.java))
    }

    private fun startGameWithAi() {
        startActivity(Intent(this, GameAIActivity::class.java))
    }
}
