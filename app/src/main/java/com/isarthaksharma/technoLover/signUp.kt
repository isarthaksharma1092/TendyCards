package com.isarthaksharma.technoLover

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.isarthaksharma.technoLover.databinding.ActivitySignUpBinding

class signUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    //firebase
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //view binding
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //coding Start

            binding.signUpbutton.setOnClickListener{
                val fName = binding.SignUpFName.editText?.text.toString()
                val sName = binding.SignUpSName.editText?.text.toString()
                val userName = binding.SignUpUserName.editText?.text.toString()
                val useremail = binding.SignUpEmail.editText?.text.toString()
                val userPhone = binding.SignUpNumber.editText?.text.toString().toLong()
                val userPass = binding.SignUpPass.editText?.text.toString()
                if(!binding.SignUpCheckBox.isChecked){
                    Toast.makeText(this,"Accept the T&C",Toast.LENGTH_SHORT).show()
                }

                if(validate_Info(fName,sName,userName,useremail,userPass)) {

                    val userInformation = userInfo(fName,sName,userName, useremail, userPhone, userPass)
                    database = Firebase.database.getReference("Users")

                    // why child. we have to enter details under Users that why we used child
                    database.child(userName).setValue(userInformation).addOnSuccessListener {
                        Toast.makeText(this, "Successfully Register", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(
                            this,
                            "Something went wrong/nRetry please",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }


            binding.moveToSignIn.setOnClickListener{
                val intent = Intent(this,signIn::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this,"Sign In", Toast.LENGTH_SHORT).show()
            }

            //coding ends
            insets
        }
    }

    private fun validate_Info(
        fName:String,
        sName:String,
        userName: String,
        useremail: String,
        userPass: String
    ): Boolean {
        if(fName == "") {
            binding.SignUpFName.helperText = "*Required"
            Toast.makeText(this,"username error", Toast.LENGTH_SHORT).show()
            return false
        }
        if(sName == "") {
            binding.SignUpSName.helperText = "*Required"
            Toast.makeText(this,"username error", Toast.LENGTH_SHORT).show()
            return false
        }
        if(userName == "") {
            binding.SignUpUserName.helperText = "*Required"
            Toast.makeText(this,"username error", Toast.LENGTH_SHORT).show()
            return false
        }
        if(useremail == "") {
            binding.SignUpEmail.helperText = "*Required"
            Toast.makeText(this,"useremail error", Toast.LENGTH_SHORT).show()
            return false
        }
        if(userPass == "") {
            binding.SignUpPass.helperText = "*Required"
            Toast.makeText(this,"userPass error", Toast.LENGTH_SHORT).show()
            return false
        }
        return true

    }
}