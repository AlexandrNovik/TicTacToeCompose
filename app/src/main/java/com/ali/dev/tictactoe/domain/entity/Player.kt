package com.ali.dev.tictactoe.domain.entity

import com.ali.dev.tictactoe.domain.Board
import com.ali.dev.tictactoe.domain.AI as GameAI

sealed class Player {
    data object User : Player()
    class AI(private val aiSeed: Seed) : Player() {
        private val ai = GameAI()
        fun findBestMove(board: Board, seed: Seed = aiSeed) = ai.findBestPosition(board, seed)
    }

}