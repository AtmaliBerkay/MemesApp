package com.berkayatmali.project1

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.berkayatmali.project1.databinding.ActivityLoginScreenBinding
import com.berkayatmali.project1.ui.HomeFragment
import kotlinx.android.synthetic.main.activity_login_screen.*


class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val preferences = getSharedPreferences("Uyelik", Context.MODE_PRIVATE)

        if(preferences.getString("Username",null) != null && preferences.getString("Password",null) != null){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("Username",preferences.getString("Username",null))
            intent.putExtra("Password",preferences.getString("Password",null))
            startActivity(intent)
        }


        btnLogin.setOnClickListener {
            if (etName.text.toString().isEmpty() || etPassword.text.toString().isEmpty()) {
                Toast.makeText(this,"Lütfen Gerekli Yerleri Doldurun",Toast.LENGTH_SHORT).show()
            }else{
                val username = etName.text.toString()
                val password = etPassword.text.toString()
                if(binding.cbHatirla.isChecked){
                    preferences.edit().putString("Username",username).apply()
                    preferences.edit().putString("Password",password).apply()
                }


                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("Username",username)
                intent.putExtra("Password",password)
                btnLogin.isEnabled = false
                Handler().postDelayed({
                    startActivity(intent)
                },500)
            }

        }

        /* tvkayıtOl.setOnClickListener {
            intent = Intent(this,KayitActivity::class.java)
            startActivity(intent)
        }  */
    }
}