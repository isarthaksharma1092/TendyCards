package com.isarthaksharma.technoLover

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.isarthaksharma.technoLover.MainActivity.Companion.key

class card1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_card1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            //code starts
            val mTextView = findViewById<TextView>(R.id.link_card1)
            mTextView.movementMethod = LinkMovementMethod.getInstance()


            val trend = findViewById<TextView>(R.id.trend)
            trend.text = intent.getStringExtra("card1")

            //code ends
            insets
        }
    }
}