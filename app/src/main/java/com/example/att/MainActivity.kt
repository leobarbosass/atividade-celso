package com.example.att

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.att.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.textSignup.setOnClickListener {
            var openSignupActivity = Intent(this, SignupActivity::class.java)

            startActivity(openSignupActivity)
        }
        binding.buttonLogin.setOnClickListener{
            login()
        }
    }

    private fun login(){
        if (validacao()){
            val email = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()

            val dados = getSharedPreferences("dados", MODE_PRIVATE)
            val emailSharedPreferences = dados.getString("email", "Email nao encontrado")
            val passwordSharedPreferences = dados.getString("password", "Senha nao encontrada")

            if(email == emailSharedPreferences && password == passwordSharedPreferences){

                val openWelcomeActivity = Intent(this, WelcomeActivity::class.java)

                startActivity(openWelcomeActivity)
            }else   {
                Toast.makeText(this, "Falha na autenticacaod", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validacao(): Boolean {

        if (binding.editTextUsername.text.isEmpty()){
            binding.editTextUsername.error = "o email é preciso para fazer login"
            return false
        }
        if (binding.editTextPassword.text.isEmpty()){
            binding.editTextPassword.error = "a senha é precisa para fazer login"
            return false
        }
        return true

    }
}


