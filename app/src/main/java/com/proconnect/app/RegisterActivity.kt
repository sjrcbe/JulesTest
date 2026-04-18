package com.proconnect.app

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var ivVisibility: ImageView
    private lateinit var btnSignUp: Button
    private lateinit var btnGoogle: LinearLayout
    private lateinit var btnApple: LinearLayout
    private lateinit var tvSignIn: TextView
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize views
        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        ivVisibility = findViewById(R.id.iv_visibility_icon)
        btnSignUp = findViewById(R.id.btn_sign_up)
        btnGoogle = findViewById(R.id.btn_google)
        btnApple = findViewById(R.id.btn_apple)
        tvSignIn = findViewById(R.id.tv_sign_in)

        // Set up click listeners
        ivVisibility.setOnClickListener {
            togglePasswordVisibility()
        }

        btnSignUp.setOnClickListener {
            handleSignUp()
        }

        btnGoogle.setOnClickListener {
            Toast.makeText(this, "Google sign up clicked", Toast.LENGTH_SHORT).show()
        }

        btnApple.setOnClickListener {
            Toast.makeText(this, "Apple sign up clicked", Toast.LENGTH_SHORT).show()
        }

        tvSignIn.setOnClickListener {
            finish() // Go back to LoginActivity
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            ivVisibility.setImageResource(R.drawable.ic_visibility)
        } else {
            etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivVisibility.setImageResource(R.drawable.ic_visibility_off)
        }
        isPasswordVisible = !isPasswordVisible
        etPassword.setSelection(etPassword.text.length)
    }

    private fun handleSignUp() {
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (name.isEmpty()) {
            etName.error = "Full name is required"
            etName.requestFocus()
            return
        }

        if (email.isEmpty()) {
            etEmail.error = "Email is required"
            etEmail.requestFocus()
            return
        }

        if (password.isEmpty()) {
            etPassword.error = "Password is required"
            etPassword.requestFocus()
            return
        }

        if (password.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            etPassword.requestFocus()
            return
        }

        // Perform sign up logic
        Toast.makeText(this, "Creating account...", Toast.LENGTH_SHORT).show()
    }
}
