package com.example.diceroller

class Dice (private val numSides: Int, private val numDice: Int) {
    private var randomNumber = getNumber()
    private var str: String = randomNumber.toString()

    fun roll(): String {
        for(i in 1 until numDice){
            var num = getNumber()
            str = "$str + $num"
        }
        return str
    }
    private fun getNumber(): Int {
        return (1..numSides).random()
    }
}