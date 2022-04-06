package com.jsstech.sharedpreferencedemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //without
    /*lateinit var etUserName: EditText
    lateinit var etUserPass: EditText
    lateinit var btSubmit: Button*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {

        //using findViewById
       /* etUserName=findViewById(R.id.edt_userName)
         etUserPass=findViewById(R.id.edt_password)
         btSubmit=findViewById(R.id.bt_submit)*/

        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences("login_state_file", Context.MODE_PRIVATE)
        bt_submit.setOnClickListener({
            //using extension

            val userId = edt_userName.text.toString()
            val userPass = edt_password.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("userId", userId)
            editor.putString("password", userPass)
            editor.apply()
            editor.commit()
            txtView_userId.text = sharedPreferences.getString("userId", "")
            txtView_userpass.text = sharedPreferences.getString("userId", "")


        })
        txtView_userId.text = sharedPreferences.getString("userId", "")
        txtView_userpass.text = sharedPreferences.getString("userId", "")

    }
}