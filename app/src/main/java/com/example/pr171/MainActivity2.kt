package com.example.pr171

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {
    lateinit var login:EditText
    lateinit var pasword:EditText
    lateinit var pref: SharedPreferences
    lateinit var text1:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login=findViewById(R.id.log)
        pasword=findViewById(R.id.pasw)
        text1=findViewById(R.id.txt)
    }

    @SuppressLint("SuspiciousIndentation")
    fun Save_pasw(v: View) {
        if (v.getId() == R.id.save) {
            pref = getPreferences(MODE_PRIVATE)
            var ed=pref.edit()
            ed.putString("login", login.getText().toString());
            ed.putString("password", pasword.getText().toString());
            ed.apply();
        }
        if(v.getId()==R.id.load){
            var alAlert=AlertDialog.Builder(this)
               alAlert.setTitle("Сохранить данные?")
           alAlert.show()

pref=getPreferences(MODE_PRIVATE)
            login.setText(pref.getString("login",""))
            pasword.setText(pref.getString("password",""))

        }        }


}