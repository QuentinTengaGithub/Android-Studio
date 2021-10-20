package com.example.helloclick

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val counterTextView : TextView = findViewById(R.id.activity_main_text_counter)
        counterTextView.text = "666"

        val resetButton : Button = findViewById(R.id.activity_main_btn_reset)
        resetButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(clickedView: View?) {
                counterTextView.text = "0"
            }
        })

        activity_main_text_counter.text = "666"
        resetButton.setOnClickListener {
            counterTextView.text = "0"
        }

        activity_main_btn_big.setOnClickListener() {
            val explicitIntent = Intent( this@MainActivity, SecondActivity::class.java)
            explicitIntent.putExtra("id", 12)
            startActivity(explicitIntent)

            val implicitIntent = Intent(Intent.ACTION_VIEW)
            implicitIntent.data = Uri.parse("http://www.epita.fr")
            startActivity(implicitIntent)

        }
    }
}