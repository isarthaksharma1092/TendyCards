package com.isarthaksharma.technoLover

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.isarthaksharma.technoLover.databinding.ActivityQuickNotesBinding

class QuickNotes : AppCompatActivity() {
    lateinit var binding: ActivityQuickNotesBinding
    companion object{
        private const val key = "com.isarthaksharma.technoLover.key"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //view binding
        binding = ActivityQuickNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            //code starts
            var userName = intent.getStringExtra("userName")
            if(userName != ""){
                binding.userName.text = userName
            }

            binding.card1.setOnClickListener{
                val intent = Intent(this,card1::class.java)
                intent.putExtra("card1",binding.card1Trend.text)
                startActivity(intent)
            }
            binding.card2.setOnClickListener{
                val intent = Intent(this,card2::class.java)
                intent.putExtra("card2",binding.card2Trend.text)
                startActivity(intent)

            }
            binding.card3.setOnClickListener{
                val intent = Intent(this,card3::class.java)
                intent.putExtra("card3",binding.card3Trend.text)
                startActivity(intent)
            }
            binding.card4.setOnClickListener{
                val intent = Intent(this,card4::class.java)
                intent.putExtra("card4",binding.card4Trend.text)
                startActivity(intent)
            }
            binding.card5.setOnClickListener{
                val intent = Intent(this,card5::class.java)
                intent.putExtra("card5",binding.card5Trend.text)
                startActivity(intent)
            }
            binding.card6.setOnClickListener{
                val intent = Intent(this,card6::class.java)
                intent.putExtra("card6",binding.card6Trend.text)
                startActivity(intent)
            }


            //code ends

            insets
        }
    }
}