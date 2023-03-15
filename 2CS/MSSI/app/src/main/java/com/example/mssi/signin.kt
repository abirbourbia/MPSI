package com.example.mssi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        val btn = findViewById<Button>(R.id.signin)
        val phone = findViewById<EditText>(R.id.numero)
        val pswd = findViewById<EditText>(R.id.pswd)
        // Login onClick
        btn.setOnClickListener {
            val phonenumber = phone.text.toString()
            val password = pswd.text.toString()
            login(phonenumber,password)
        }
    }

    private fun login(phonenumber: String,password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response =  RetrofitService.endpoint.login(LoginCreds(phonenumber,password))
            withContext(Dispatchers.Main) {
                if(response.isSuccessful) {
                    val user = response.body()
                    if(user!=null) {
                        val pref = getSharedPreferences("fileName", MODE_PRIVATE)
                        pref.edit {
                            putInt("idUser",user.id)
                            putString("userName", user.fullname)
                            putString("phoneNumber",user.phonenumber)
                            putBoolean("connected",true)
                        }
                        println("username isssssss"+pref.getInt("idUser",0))
                        val intent = Intent(this@signin,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this@signin,"Recheck Phone Number or Password ", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this@signin,response.toString(), Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}