package com.ali.dev.tictactoe.domain.entity

data class Move(val position: Position = Position(0, 0), val seed: Seed = Seed.Empty)