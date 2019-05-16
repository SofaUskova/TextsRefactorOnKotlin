package com.example.textonkotlin.activities

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.textonkotlin.R
import com.example.textonkotlin.utils.*
import kotlinx.android.synthetic.main.activity_create_or_refactor_file.*

class CreateFileActivity : AppCompatActivity() {
    private val FILENAME = "data.txt"
    private var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_or_refactor_file)
    }

    override fun onPause() {
        super.onPause()
        saveFile(FILENAME, editText, context)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(
            Intent(this, MainActivity::class.java)
                .addFlags(FLAG_ACTIVITY_CLEAR_TOP)
        )
    }
}
