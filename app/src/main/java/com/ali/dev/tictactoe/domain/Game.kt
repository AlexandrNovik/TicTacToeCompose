package com.ali.dev.tictactoe.domain

import com.ali.dev.tictactoe.domain.entity.Move
import com.ali.dev.tictactoe.domain.entity.Player
import com.ali.dev.tictactoe.domain.entity.Seed
import com.ali.dev.tictactoe.domain.entity.reverse

class Game(size: Int = 3) {
    private var board = Board(size, hashMapOf()).apply { initGameTable() }

    fun playAIWithAI(moveListener: (Move) -> Unit) {
        val startTime = System.currentTimeMillis()
        val ai = Player.AI(Seed.O)
        var seed: Seed = Seed.O
        while (board.getStatus().isFinished.not()) {
            seed = seed.reverse()
            val pos = ai.findBestMove(board, seed)
            moveListener(Move(pos, seed))
            board.setPosition(pos, seed)
            board.printInConsole()
        }
        println("Time: ${System.currentTimeMillis() - startTime}ms")
    }
}