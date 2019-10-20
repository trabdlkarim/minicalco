package com.trabdlkarim.minicalco

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var ans:Double = 0.0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayEditText= findViewById<EditText>(R.id.displayEditText)
        displayEditText.showSoftInputOnFocus = false
        val displayTextView = findViewById<TextView>(R.id.displayTextView)
        val clearButton = findViewById<Button>(R.id.clearButton)
        clearButton.setOnClickListener {
            displayEditText.text.clear()
            displayTextView.text = resources.getString(R.string.reset_text)
        }
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        deleteButton.setOnClickListener {
            val len = displayEditText.text.length
            if(len>1) displayEditText.text.delete(len-1,len)
            else displayEditText.text.clear()
        }

        val leftparen = findViewById<Button>(R.id.leftParentheseButton)
        leftparen.setOnClickListener { displayEditText.text = displayEditText.text.append("(") }
        val rightparen = findViewById<Button>(R.id.rightParentheseButton)
        rightparen.setOnClickListener { displayEditText.text.append(")") }
        val dotButton = findViewById<Button>(R.id.dotButton)
        dotButton.setOnClickListener { displayEditText.text.append(".") }

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener { displayEditText.text.append("+")}
        val subButton = findViewById<Button>(R.id.subButton)
        subButton.setOnClickListener { displayEditText.text.append("-") }
        val mulButton = findViewById<Button>(R.id.mulButton)
        mulButton.setOnClickListener { displayEditText.text.append("x") }
        val divButton = findViewById<Button>(R.id.divButton)
        divButton.setOnClickListener { displayEditText.text.append("/") }

        val answerButton = findViewById<Button>(R.id.answerButton)
        answerButton.setOnClickListener {
            displayEditText.text.clear()
            displayEditText.text.append(ans.toString())
        }


        val powerButton = findViewById<Button>(R.id.powerButton)
        powerButton.setOnClickListener { displayEditText.text.append("^") }

        val squareRootButton = findViewById<Button>(R.id.sqrtButton)
        squareRootButton.setOnClickListener { displayEditText.text.append("sqrt(") }

        val cosineButton = findViewById<Button>(R.id.cosineButton)
        cosineButton.setOnClickListener { displayEditText.text.append("cos(") }

        val sineButton = findViewById<Button>(R.id.sineButton)
        sineButton.setOnClickListener { displayEditText.text.append("sin(") }

        val tangentButton = findViewById<Button>(R.id.tangentButton)
        tangentButton.setOnClickListener { displayEditText.text.append("tan(") }

        val equalityButton = findViewById<Button>(R.id.equalityButton)
        equalityButton.setOnClickListener {
            val expression = displayEditText.text.toString()
            if(expression.isNotEmpty()){
                try {
                    val eval = SimpleArithmeticExprEvaluator.evaluate(expression)
                    val result: String = eval.toString()
                    val i = result.lastIndexOf('.')
                    if (result[i+1] =='0' && result.length==i+2)
                        displayTextView.text = result.split('.')[0] + '.'
                    else  displayTextView.text= result
                    ans=eval
                }catch (runEx:RuntimeException ){
                    Toast.makeText(this,resources.getString(R.string.error_msg),Toast.LENGTH_SHORT).show()
                }

            }

        }

        val zeroButton = findViewById<Button>(R.id.zeroButton)
        zeroButton.setOnClickListener {  displayEditText.text.append("0") }
        val oneButton = findViewById<Button>(R.id.oneButton)
        oneButton.setOnClickListener {  displayEditText.text.append("1") }
        val twoButton = findViewById<Button>(R.id.twoButton)
        twoButton.setOnClickListener {  displayEditText.text.append("2") }
        val threeButton = findViewById<Button>(R.id.threeButton)
        threeButton.setOnClickListener {  displayEditText.text.append("3") }
        val fourButton = findViewById<Button>(R.id.fourButton)
        fourButton.setOnClickListener {  displayEditText.text.append("4") }
        val fiveButton = findViewById<Button>(R.id.fiveButton)
        fiveButton.setOnClickListener {  displayEditText.text.append("5") }
        val sixButton = findViewById<Button>(R.id.sixButton)
        sixButton.setOnClickListener {  displayEditText.text.append("6") }
        val sevenButton = findViewById<Button>(R.id.sevenButton)
        sevenButton.setOnClickListener {  displayEditText.text.append("7") }
        val eightButton = findViewById<Button>(R.id.eightButton)
        eightButton.setOnClickListener {  displayEditText.text.append("8") }
        val nineButton = findViewById<Button>(R.id.nineButton)
        nineButton.setOnClickListener {  displayEditText.text.append("9") }
    }

}
