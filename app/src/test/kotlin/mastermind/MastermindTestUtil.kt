package mastermind

import org.junit.Assert

fun testEvaluation(first: String, second: String, right: Int, wrong: Int) {
    val evaluation = Evaluation(right, wrong)

    testEvaluationOneWay(secret = first, guess = second, expected = evaluation)
    testEvaluationOneWay(guess = second, secret = first, expected = evaluation)
}

fun testEvaluationOneWay(secret: String, guess: String, expected: Evaluation) {

    val evaluation = evaluateGuess(
        identifyInput(
            secret.split("")
        ), identifyInput(
            guess.split("")
        )
    )
    Assert.assertEquals("Wrong evaluation for secret=$secret, guess=$guess",
        expected, evaluation)
}
