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

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var ivVisibility: ImageView
    private lateinit var btnSignIn: Button
    private lateinit var tvForgotPassword: TextView
    private lateinit var btnGoogle: LinearLayout
    private lateinit var btnApple: LinearLayout
    private lateinit var tvSignUp: TextView
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        ivVisibility = findViewById(R.id.iv_visibility_icon)
        btnSignIn = findViewById(R.id.btn_sign_in)
        tvForgotPassword = findViewById(R.id.tv_forgot_password)
        btnGoogle = findViewById(R.id.btn_google)
        btnApple = findViewById(R.id.btn_apple)
        tvSignUp = findViewById(R.id.tv_sign_up)

        // Set up click listeners
        ivVisibility.setOnClickListener {
            togglePasswordVisibility()
        }

        btnSignIn.setOnClickListener {
            handleSignIn()
        }

        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show()
        }

        btnGoogle.setOnClickListener {
            Toast.makeText(this, "Google sign in clicked", Toast.LENGTH_SHORT).show()
        }

        btnApple.setOnClickListener {
            Toast.makeText(this, "Apple sign in clicked", Toast.LENGTH_SHORT).show()
        }

        tvSignUp.setOnClickListener {
            Toast.makeText(this, "Sign up clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            ivVisibility.setImageResource(R.drawable.ic_visibility)
        } else {
            etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            // In a real app, you might use a different icon for 'off' state
            ivVisibility.setImageResource(R.drawable.ic_visibility)
        }
        isPasswordVisible = !isPasswordVisible
        etPassword.setSelection(etPassword.text.length)
    }

    private fun handleSignIn() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

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

        // Perform sign in logic
        Toast.makeText(this, "Signing in...", Toast.LENGTH_SHORT).show()
    }
}
