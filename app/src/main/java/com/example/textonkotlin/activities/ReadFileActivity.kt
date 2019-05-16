package com.example.textonkotlin.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.textonkotlin.R
import com.example.textonkotlin.utils.readFileText
import kotlinx.android.synthetic.main.activity_read_file.*

class ReadFileActivity : AppCompatActivity() {
    private val FILENAME = "data.txt"
    private var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_file)

        readFileText(FILENAME, textView, context)
    }
}