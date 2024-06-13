package com.ali.dev.tictactoe.domain.entity

import com.ali.dev.tictactoe.domain.Board
import com.ali.dev.tictactoe.domain.AI as GameAI

sealed class Player {
    data object User : Player()
    data object AI : Player() {
        private val ai = GameAI()
        fun findBestMove(board: Board, seed: Seed) = ai.findBestPosition(board, seed)
    }

}