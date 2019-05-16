package com.example.textonkotlin.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.textonkotlin.R
import com.example.textonkotlin.utils.readFileEditText
import com.example.textonkotlin.utils.saveFile
import kotlinx.android.synthetic.main.activity_create_or_refactor_file.*

class RefactorFileActivity : AppCompatActivity() {
    private val FILENAME = "data.txt"
    private var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_or_refactor_file)

        readFileEditText(FILENAME, editText, context)
    }

    override fun onPause() {
        super.onPause()
        saveFile(FILENAME, editText, context)
    }
}