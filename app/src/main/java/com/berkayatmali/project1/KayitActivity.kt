package com.berkayatmali.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kayit.*

class KayitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kayit)

        btnKayıt.setOnClickListener {
            if (etNameKayıt.text.toString().isEmpty() || etPasswordKayıt.text.toString().isEmpty() || etMail.text.toString().isEmpty()){
                Toast.makeText(this,"Lütfen Gerekli Yerleri Doldurun", Toast.LENGTH_SHORT).show()
            }
            else{

                btnKayıt.isEnabled = false

                Handler().postDelayed({
                    startActivity(intent)
                } ,5000 )

                intent = Intent(this,LoginScreen::class.java)
                startActivity(intent)

            }
        }
    }
}