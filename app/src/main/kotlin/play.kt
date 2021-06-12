package mastermind

import models.Code
import models.ColorsEnum
import models.Pin

val ALPHABET_PAIRS = ColorsEnum.values().map { it.initial to it.name }
val ALPHABET = ColorsEnum.values().map { it.initial }
const val CODE_LENGTH = 4

fun main() {
    playMastermind()
}

fun playMastermind(
    secret: Code = generateSecret()
) {
    var evaluation: Evaluation

    do {
        print("Your guess: ")

        val guess = readAndValidateInput(readLine()!!)
        val interpretedGuess = identifyInput(guess)

        evaluation = evaluateGuess(secret, interpretedGuess)
        if (evaluation.isComplete()) {
            println("The guess is correct!")
        } else {
            println("Right positions: ${evaluation.rightPosition}; " +
                    "wrong positions: ${evaluation.wrongPosition}.")
        }

    } while (!evaluation.isComplete())
}

fun Evaluation.isComplete(): Boolean = rightPosition == CODE_LENGTH

fun hasErrorsInInput(guess: List<String>): Boolean {
    return guess.size != CODE_LENGTH || guess.any { it !in ALPHABET }
}

fun generateSecret(): Code {
    return Code(Pin.makeARandomList(CODE_LENGTH))
}

fun readAndValidateInput(input: String) : List<String> {
    var guess = input.split("").verify()

    while (hasErrorsInInput(guess)) {
        println("Incorrect input: $guess. " +
                "It should consist of $CODE_LENGTH characters from $ALPHABET_PAIRS. ")
        println("Please try again.")
        guess = readLine()!!.split("").verify()
    }

    return guess
}

fun identifyInput(guess: List<String>) : Code {

    val pins = mutableListOf<Pin>()

    for (t in guess.verify()) {
        val colorName = ALPHABET_PAIRS.find { color -> t == color.first }!!.second
        val color = ColorsEnum.valueOf(colorName)

        pins.add(Pin(color, guess.indexOf(t)))
    }

    return Code(pins)
}

fun List<String>.verify (): List<String> {
    return this.filter { it != "" && it != " " }
}