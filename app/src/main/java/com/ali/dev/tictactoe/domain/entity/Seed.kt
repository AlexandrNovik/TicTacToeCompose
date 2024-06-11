package com.ali.dev.tictactoe.domain.entity

sealed class Seed {
    data object Empty : Seed()
    data object O : Seed()
    data object X : Seed()
}

fun Seed.reverse(): Seed {
    if (this is Seed.Empty) return this
    return if (this is Seed.O) Seed.X else Seed.O
}

fun Seed.print(): String {
    if (this is Seed.Empty) return " "
    return if (this is Seed.O) "0" else "X"
}