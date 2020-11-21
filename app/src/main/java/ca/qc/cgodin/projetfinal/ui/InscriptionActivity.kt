package ca.qc.cgodin.projetfinal.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import ca.qc.cgodin.projetfinal.R

class InscriptionActivity : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)
        val email= findViewById<EditText>(R.id.email)
        val username= findViewById<EditText>(R.id.username)
        val password1= findViewById<EditText>(R.id.password)
        val password2= findViewById<EditText>(R.id.confirm_password)
      /*  val register= findViewById(R.id.btnCreerCompte) as Button
        register.setOnClickListener{
            Toast.makeText(this, "email "+email.text+"username "+username.text+"password1 "+password1.text+"password2 "+password2.text, Toast.LENGTH_SHORT).show()
        }*/



    }

}