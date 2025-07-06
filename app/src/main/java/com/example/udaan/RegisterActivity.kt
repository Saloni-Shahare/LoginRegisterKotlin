package com.example.udaan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerUsername = findViewById<EditText>(R.id.registerUsername)
        val registerPassword = findViewById<EditText>(R.id.registerPassword)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val backToLogin = findViewById<Button>(R.id.backToLogin)

        val preferences = getSharedPreferences("user_details", Context.MODE_PRIVATE)

        registerButton.setOnClickListener {
            val username = registerUsername.text.toString()
            val password = registerPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                preferences.edit()
                    .putString("username", username)
                    .putString("password", password)
                    .apply()

                Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show()
            }
        }

        backToLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
