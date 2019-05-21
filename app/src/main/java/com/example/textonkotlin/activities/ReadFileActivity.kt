package com.example.textonkotlin.activities

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.textonkotlin.R
import com.example.textonkotlin.utils.readFileText
import kotlinx.android.synthetic.main.activity_read_file.*
import kotlinx.android.synthetic.main.activity_settings.*

class ReadFileActivity : AppCompatActivity() {
    private val FILENAME = "data.txt"
    private var context: Context = this
    private lateinit var mSettings: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_file)

        mSettings = getSharedPreferences("settings", MODE_PRIVATE)

        if(mSettings.contains("TEXT_COLOR")) {
            textViewRead.setTextColor(mSettings.getInt("TEXT_COLOR", 0))
        }
        if(mSettings.contains("TEXT_SIZE")) {
            textViewRead.textSize = mSettings.getInt("TEXT_SIZE", 0).toFloat()
        }

        readFileText(FILENAME, textViewRead, context)
    }
}