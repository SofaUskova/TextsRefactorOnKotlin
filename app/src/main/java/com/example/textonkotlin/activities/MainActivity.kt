package com.example.textonkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.textonkotlin.R
import com.example.textonkotlin.utils.isExists
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_open_file.*

class MainActivity : AppCompatActivity() {
    private val FILENAME = "/data/data/com.example.textonkotlin/files/data.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isExists(FILENAME)) {
            setContentView(R.layout.activity_open_file)
            openFile.setOnClickListener(this::onClickRead)
            refactorFile.setOnClickListener(this::onClickRefactor)
        } else {
            setContentView(R.layout.activity_main)
            createFile.setOnClickListener(this::onClickCreate)
        }

    }

    private fun onClickCreate(v: View) {
        startActivity(
            Intent(this, CreateFileActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        )
    }

    private fun onClickRead(v: View) {
        startActivity(
            Intent(this, ReadFileActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        )
    }

    private fun onClickRefactor(v: View) {
        startActivity(
            Intent(this, RefactorFileActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        )
    }
}
