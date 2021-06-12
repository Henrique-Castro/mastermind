package mastermind

import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestMastermindDifferentLetters {

    @Test
    fun test01SampleEqual() = testEvaluation("BROW", "BROW  ", 4, 0)

    @Test
    fun test02SampleOnlyWrongPositions() = testEvaluation("BROW", "WORB", 0, 4)

    @Test
    fun test03SampleSwap() = testEvaluation("BROW", "BRWO", 2, 2)

    @Test
    fun test04RightPositions() = testEvaluation("BROW", "BROR", 3, 1)

    @Test
    fun test05WrongPositions() = testEvaluation("ROWK", "RWKO", 1, 3)

    @Test
    fun test06BothRightAndWrong() = testEvaluation("ROWK", "RKWO", 2, 2)

    @Test
    fun test07() = testEvaluation("BROW", "ROWK", 0, 4)

    @Test
    fun test08() = testEvaluation("BROW", "ORKW", 2, 2)

    @Test
    fun test09() = testEvaluation("BROW", "BROR", 3, 1)

    @Test
    fun test10() = testEvaluation("BROW", "YGRB", 0, 4)

    @Test
    fun test11() = testEvaluation("BROW", "BROW", 4, 0)

    @Test
    fun test12() = testEvaluation("ROWK", "YGRB", 0, 4)

    @Test
    fun test13() = testEvaluation("ROWK", "BROR", 0, 4)

    @Test
    fun test14() = testEvaluation("ROWK", "ORKW", 0, 4)

    @Test
    fun test15() = testEvaluation("ROWK", "ROWK", 4, 0)

    @Test
    fun test16() = testEvaluation("OOWW", "GKWW", 2, 2)

    @Test
    fun test17() = testEvaluation("GOWW", "GKKW", 2, 2)

    @Test
    fun test18() = testEvaluation("OOWW", "OOKK", 2, 2)

    @Test
    fun test19() = testEvaluation("OOWW", "OWOW", 2, 2)

    @Test
    fun test20() = testEvaluation("OOBW", "GKBW", 2, 2)

}
