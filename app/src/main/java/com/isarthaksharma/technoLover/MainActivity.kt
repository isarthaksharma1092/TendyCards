package com.isarthaksharma.technoLover

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.isarthaksharma.technoLover.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val key = "package.MainActivity.key"
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            //code starts
            binding.letsGo.setOnClickListener{
                val myIntent = Intent(this,QuickNotes::class.java)
                myIntent.putExtra("userName",binding.editMsg.text.toString())

                startActivity(myIntent)
                finish()
            }

            //code ends
            insets
        }
    }
}