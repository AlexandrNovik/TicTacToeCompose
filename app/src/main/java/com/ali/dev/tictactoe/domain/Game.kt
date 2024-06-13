package com.ali.dev.tictactoe.domain

import com.ali.dev.tictactoe.domain.entity.Move
import com.ali.dev.tictactoe.domain.entity.Player.AI
import com.ali.dev.tictactoe.domain.entity.Position
import com.ali.dev.tictactoe.domain.entity.Seed
import com.ali.dev.tictactoe.domain.entity.reverse

class Game(size: Int = 3) {
    private var board = Board(size, hashMapOf()).apply { initGameTable() }

    fun playAIWithAI(moveListener: (Move) -> Unit) {
        val startTime = System.currentTimeMillis()
        var seed: Seed = Seed.O
        while (board.getStatus().isFinished.not()) {
            seed = seed.reverse()
            val pos = AI.findBestMove(board, seed)
            moveListener(Move(pos, seed))
            board.setPosition(pos, seed)
            board.printInConsole()
        }
        println("Time: ${System.currentTimeMillis() - startTime}ms")
    }

    fun moveWithAI(prevSeed: Seed): Move? {
        if (board.getStatus().isFinished.not()) {
            val seed = prevSeed.reverse()
            val pos = AI.findBestMove(board, seed)
            board.setPosition(pos, seed)
            board.printInConsole()
            return Move(pos, seed)
        } else {
            return null
        }

    }

    fun setMove(seed: Seed, position: Position) {
        if (board.getStatus().isFinished.not()) {
            board.setPosition(position, seed)
            board.printInConsole()
        } else {
            throw IllegalStateException("Board is full")
        }

    }
}