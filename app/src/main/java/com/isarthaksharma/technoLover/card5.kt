package com.isarthaksharma.technoLover

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class card5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //code starts
            val mTextView = findViewById<TextView>(R.id.link_card5)
            mTextView.movementMethod = LinkMovementMethod.getInstance()

            val trend = findViewById<TextView>(R.id.trend)
            trend.text = intent.getStringExtra("card5")


            //code ends
            insets
        }
    }
}