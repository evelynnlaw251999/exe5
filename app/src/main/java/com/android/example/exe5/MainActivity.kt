package com.android.example.exe5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log


class MainActivity : AppCompatActivity() {

    var dislike: Int = 0
     var like = 0
    lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreference = this.getPreferences(Context.MODE_PRIVATE)

        Log.d("MainActivity", "onCreate")

        imageViewLike.setOnClickListener{
            like++
            textViewLike.text = like.toString()
        }

        imageViewDislike.setOnClickListener{
            dislike++
            textViewDislike.text = dislike.toString()
        }

    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume")
        //Retrieve counters from the SharedPref
        like = sharedPreference.getInt(getString(R.string.app_name),0)
        dislike = sharedPreference.getInt(getString(R.string.app_name), 0)
        textViewLike.text = like.toString()
        textViewDislike.text = dislike.toString()
        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPause")
        with(sharedPreference.edit()){
            putInt(getString(R.string.app_name), like)
            putInt(getString(R.string.app_name), dislike)
            commit()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }

}
