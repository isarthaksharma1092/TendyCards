package com.isarthaksharma.technoLover

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.isarthaksharma.technoLover.databinding.ActivitySignInBinding

class signIn : AppCompatActivity() {
    lateinit var binding:ActivitySignInBinding
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //view binding
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            //coding Start
            binding.Loginbutton.setOnClickListener{
                val username = binding.LoginName.editText?.text.toString()
                val pass = binding.LoginPass.editText?.text.toString()

                if(validateInfo(username,pass)){
                    readData(username,pass)
                }
            }
            binding.moveToSignUp.setOnClickListener{
                val intent = Intent(this,signUp::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Create Account",Toast.LENGTH_SHORT).show()
            }
            insets
        }
    }

    private fun readData(username: String,pass:String) {
        val auth = Firebase.auth
        auth.signInWithEmailAndPassword(username,pass).addOnCompleteListener(this){ task->
            if(task.isSuccessful){
                val user = auth.currentUser

                val fname = user?.displayName // Assuming the user's name is stored in the displayName field
                Toast.makeText(this, "Welcome $fname", Toast.LENGTH_SHORT).show()

                val myIntent = Intent(this, MainActivity::class.java)
                myIntent.putExtra("first_Name", fname)
                startActivity(myIntent)
            }

            else{
                Toast.makeText(
                    this,"User not found! $username",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInfo(username: String, pass: String): Boolean {
        if(username == ""){
            binding.LoginName.helperText = "*Required"
            return false
        }
        if(pass == ""){
            binding.LoginPass.helperText = "*Required"
            return false
        }
        return true
    }
}