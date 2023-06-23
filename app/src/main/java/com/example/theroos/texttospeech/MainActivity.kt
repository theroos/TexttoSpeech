package com.example.theroos.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.*


lateinit var tts : TextToSpeech

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonspeech = findViewById<Button>(R.id.button_speech)
        var textt = findViewById<EditText>(R.id.edittext_text)

        buttonspeech.setOnClickListener {
            tts = TextToSpeech(applicationContext,TextToSpeech.OnInitListener {
                if(it == TextToSpeech.SUCCESS){
                    tts.language = Locale.US
                    tts.setSpeechRate(1.1f)
                    tts.speak(textt.text.toString(),TextToSpeech.QUEUE_ADD,null)

                }
            })
        }
    }
}