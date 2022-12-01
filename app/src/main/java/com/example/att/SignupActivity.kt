package com.example.att

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.att.Model.User

class SignupActivity : AppCompatActivity(){

    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_singup)

        editName = findViewById(R.id.text_name)
        editEmail = findViewById(R.id.text_email)
        editPassword = findViewById(R.id.text_password)
        buttonSave = findViewById(R.id.save_user)

        buttonSave.setOnClickListener {
            salvarUsuario()
        }
    }

    private fun salvarUsuario() {

        val user = User()

        user.id = 1
        user.name = editName.text.toString()
        user.email = editEmail.text.toString()
        user.password = editPassword.text.toString()


        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        val editor = dados.edit()

        editor.putInt("id", user.id)
        editor.putString("name", user.name)
        editor.putString("email", user.email)
        editor.putString("password", user.password)

        if(editor.commit()){
            Toast.makeText(this, "Usuario foi registrado com sucesso", Toast.LENGTH_SHORT).show()

            finish()
        }else{
            Toast.makeText(this, "Registro do usuario falhou", Toast.LENGTH_SHORT).show()

        }
    }

}