package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.diceroller.R

class MainActivity : AppCompatActivity() {


    private val maxFaceValue: Int = 100
    private val maxDiceValue: Int = 40
    private val minFaceValue: Int = 2
    private val minDiceValue: Int = 1
    private lateinit var rollButton: Button
    private lateinit var clearButton: Button
    private lateinit var decreaseFaceButton: ImageButton
    private lateinit var increaseFaceButton: ImageButton
    private lateinit var decreaseDiceButton: ImageButton
    private lateinit var increaseDiceButton: ImageButton
    private lateinit var numOfFace: TextView
    private lateinit var numOfDice: TextView
    private lateinit var results: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        clearButton = findViewById(R.id.clear_button)
        decreaseFaceButton = findViewById(R.id.decrease_face_button)
        increaseFaceButton = findViewById(R.id.increase_face_button)
        decreaseDiceButton = findViewById(R.id.decrease_dice_button)
        increaseDiceButton = findViewById(R.id.increase_dice_button)
        numOfFace  = findViewById(R.id.number_of_faces_edit)
        numOfDice = findViewById(R.id.number_of_dice_edit)
        results = findViewById(R.id.results_text)

        var face: Int = 6
        var dice: Int = 1

        rollButton.setOnClickListener {
            val rollDice = Dice(face, dice)
            val rollResult = rollDice.roll()
            results.text = rollResult
        }
        clearButton.setOnClickListener{
            results.text = ""
        }

        increaseFaceButton.setOnClickListener{
            face = changeFace(face, true, maxFaceValue, minFaceValue)
            numOfFace.text = face.toString()
        }
        decreaseFaceButton.setOnClickListener{
            face = changeFace(face, false, maxFaceValue, minFaceValue)
            numOfFace.text = face.toString()
        }
        increaseDiceButton.setOnClickListener{
            dice = changeFace(dice, true, maxDiceValue, minDiceValue)
            numOfDice.text = dice.toString()
        }
        decreaseDiceButton.setOnClickListener{
            dice = changeFace(dice, true, maxDiceValue, minDiceValue)
            numOfDice.text = dice.toString()
        }
    }

    private fun changeFace(value: Int, isIncrease: Boolean, max: Int, min: Int): Int{
        var num : Int = value
        if (isIncrease) {
            if(num != max){
                num++
            } else {
                Toast.makeText(this, "Maximum is $max", Toast.LENGTH_SHORT).show()
            }
        } else {
            if(num != min){
                num--
            } else {
                Toast.makeText(this, "Minimum is $min", Toast.LENGTH_SHORT).show()
            }
        }
        return num
    }


}

