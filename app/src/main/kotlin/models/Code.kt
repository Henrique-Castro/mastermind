package models

import kotlin.random.Random

class Code(val pins: List<Pin>)

class Pin(
    val color: ColorsEnum,
    val position: Int
) {
    companion object {
        fun makeARandomList(length: Int): List<Pin> {
            val result = mutableListOf<Pin>()
            val colorsLength = ColorsEnum.values().size

            for (i in 1..length) {
                val color = ColorsEnum.values()[Random.nextInt(colorsLength)]
                result.add(Pin(color,i))
            }

            return result.toList()
        }
    }
}

