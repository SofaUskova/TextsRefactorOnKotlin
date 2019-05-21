package com.example.textonkotlin.activities

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.textonkotlin.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    private lateinit var mSettings: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private var textColorSave: Int = 0
    private var textSizeSave: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        mSettings = getSharedPreferences("settings", MODE_PRIVATE)
        editor = mSettings.edit()

        textSize.setOnClickListener(this::onClickTextSize)
        sizeTextSmall.setOnClickListener(this::onClickTextSize)
        sizeTextMiddle.setOnClickListener(this::onClickTextSize)
        sizeTextBig.setOnClickListener(this::onClickTextSize)
        textColor.setOnClickListener(this::onClickTextColor)
        colorTextBlack.setOnClickListener(this::onClickTextColor)
        colorTextPink.setOnClickListener(this::onClickTextColor)
        colorTextBlue.setOnClickListener(this::onClickTextColor)
    }

    private fun onClickTextSize(v: View) {
        textSizeSave = when (v.id) {
            R.id.sizeTextSmall -> {
                textView.textSize = 10F
                10
            }
            R.id.sizeTextMiddle -> {
                textView.textSize = 20F
                20
            }
            R.id.sizeTextBig -> {
                textView.textSize = 30F
                30
            }
            else ->
                20
        }
    }

    private fun onClickTextColor(v: View) {
        textColorSave = when (v.id) {
            R.id.colorTextBlack -> {
                textView.setTextColor(Color.parseColor("#021c0a"))
                Color.parseColor("#021c0a")
            }
            R.id.colorTextPink -> {
                textView.setTextColor(Color.parseColor("#ff9eb5"))
                Color.parseColor("#ff9eb5")
            }
            R.id.colorTextBlue -> {
                textView.setTextColor(Color.parseColor("#059bff"))
                Color.parseColor("#059bff")
            }
            else ->
                Color.parseColor("#021c0a")
        }
    }

    override fun onPause() {
        super.onPause()
        editor.putInt("TEXT_SIZE", textSizeSave.toInt())
        editor.apply()
        editor.putInt("TEXT_COLOR", textColorSave)
        editor.apply()
    }
}