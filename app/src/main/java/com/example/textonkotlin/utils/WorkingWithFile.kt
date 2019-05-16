package com.example.textonkotlin.utils

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import java.io.*

fun saveFile(fileName: String, editText: EditText, context: Context) {
    try {
        val osw = OutputStreamWriter(context.openFileOutput(fileName, 0))
        osw.write(editText.text.toString())
        osw.close()
    } catch (t: Throwable) {
        //log
    }
}

fun readFileText(fileName: String, textView: TextView, context: Context) {
    try {
        val br = BufferedReader(InputStreamReader(context.openFileInput(fileName)))
        var str: String
        var i = 0
        do {
            str = br.readLine()
            textView.append("${i++}. $str\n")
        } while (str != null)
    } catch (e: Exception) {
        //log
    }
}

fun readFileEditText(fileName: String, editText: EditText, context: Context) {
    try {
        val br = BufferedReader(InputStreamReader(context.openFileInput(fileName)))
        var str: String
        do {
            str = br.readLine()
            editText.append("$str\n")
        } while (str != null)
    } catch (e: Exception) {
        //log
    }
}

fun isExists(fileName: String): Boolean {
    return File(fileName).exists()
}

