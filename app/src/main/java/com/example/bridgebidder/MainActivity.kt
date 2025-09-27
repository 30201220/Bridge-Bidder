package com.example.bridgebidder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    var boards : Array<Board> = arrayOf(Board(0))
    var numOfBroads = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var b_start: Button = findViewById(R.id.start_button)
        var numOfBroads: TextView = findViewById(R.id.broads_text)
        b_start.setOnClickListener{
            this.numOfBroads = numOfBroads.text.toString().toInt()
            if(this.numOfBroads > 0 && this.numOfBroads <= 48) {
//                for (i in 1..this.numOfBroads) {
//                    boards += Board(i)
//                }
                startActivity(Intent(this, BiddingPage::class.java).putExtra("numOfBroads", this.numOfBroads))
            } else {
                Toast.makeText(this, "wrong input!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}