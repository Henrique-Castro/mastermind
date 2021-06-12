package mastermind

import models.Code
import models.Pin

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(code: Code, guess: Code): Evaluation {
    val errors = mutableListOf<Pin>()

    for (i in 0 until CODE_LENGTH) {
        if (code.pins[i].color != guess.pins[i].color) {
            errors.add(guess.pins[i])
        }
    }

    return Evaluation(CODE_LENGTH - errors.size, errors.size)
}
