package com.ali.dev.tictactoe.domain

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import com.ali.dev.tictactoe.domain.entity.Position
import com.ali.dev.tictactoe.domain.entity.Seed
import com.ali.dev.tictactoe.domain.entity.reverse

@SuppressLint("MutableCollectionMutableState")
object GameHolder {
    val move = mutableStateOf(Pair<Position, Seed>(Position(-1, -1), Seed.Empty))
    private val map = mutableMapOf<Position, Seed>()
    private var seed: Seed = Seed.O

    fun start() {
        Thread {
            clear()
            Game().playAIWithAI {
                map[it.position] = seed
                move.value = it.position to it.seed
                Thread.sleep(100)
            }
        }.start()
    }

    fun makeMove(position: Position) {
        if (map[position] != null) return
        val reversed = seed.reverse()
        seed = reversed
        map[position] = reversed
        move.value = position to reversed
    }

    fun clear() {
        seed = Seed.O
        map.clear()
        move.value = Position(-1, -1) to Seed.Empty
    }
}