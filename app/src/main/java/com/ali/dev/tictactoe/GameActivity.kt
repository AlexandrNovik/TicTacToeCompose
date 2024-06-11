package com.ali.dev.tictactoe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ali.dev.tictactoe.domain.GameHolder
import com.ali.dev.tictactoe.domain.entity.Position
import com.ali.dev.tictactoe.domain.entity.Seed
import com.ali.dev.tictactoe.domain.entity.print
import com.ali.dev.tictactoe.ui.theme.TicTacToeTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class GameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    TicTacToeGame()
                }
            }
        }
    }

    @Preview
    @Composable
    fun TicTacToeGame() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxHeight()
        ) {
            TopBar()
            PlayField()
            StartButton()
            ClearButton()
        }
    }

    @Composable
    private fun StartButton() {
        val buttonPadding = 10.dp
        val textPadding = 5.dp
        Button(
            onClick = { startGame() },
            modifier = Modifier
                .padding(buttonPadding)
                .fillMaxWidth(0.6F)
        ) {
            Text(text = "Start Game", Modifier.padding(textPadding))
        }
    }

    @Composable
    private fun ClearButton() {
        val buttonPadding = 10.dp
        val textPadding = 5.dp
        Button(
            onClick = { GameHolder.clear() },
            modifier = Modifier
                .padding(buttonPadding)
                .fillMaxWidth(0.6F)
        ) {
            Text(text = "Restart", Modifier.padding(textPadding))
        }
    }

    private fun startGame() {
        GameHolder.start()
    }

    @Composable
    private fun PlayField() {
        val move = remember { GameHolder.move }
        val map = remember { mutableMapOf<Position, Seed>() }
        if (move.value.first.x == -1) {
            map.clear()
        } else {
            map[move.value.first] = move.value.second
        }

        Column(Modifier.padding(8.dp)) {
            Row(Modifier.fillMaxWidth()) {
                Card(Position(2, 0), map)
                Card(Position(2, 1), map)
                Card(Position(2, 2), map)
            }
            Row(Modifier.fillMaxWidth()) {
                Card(Position(1, 0), map)
                Card(Position(1, 1), map)
                Card(Position(1, 2), map)
            }
            Row(Modifier.fillMaxWidth()) {
                Card(Position(0, 0), map)
                Card(Position(0, 1), map)
                Card(Position(0, 2), map)
            }
        }
    }

    @Composable
    @Preview
    private fun TopBar() {
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
    }

    @Composable
    private fun RowScope.Card(
        position: Position,
        map: Map<Position, Seed>,
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        ) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .clickable(onClick = { GameHolder.makeMove(position) }),
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation()
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = map[position]?.print() ?: "", textAlign = TextAlign.Center)
                }
            }
        }
    }

}
