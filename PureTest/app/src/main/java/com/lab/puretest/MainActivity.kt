package com.lab.puretest

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, RecognitionListener {

    private val tag = javaClass.simpleName
    private val recordAudioRequestCode = 1
    private val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
    private val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

    init {
        speechRecognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        speechRecognizer.setRecognitionListener(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // speech to text
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            checkPermission()
        }



        listen.setOnClickListener(this)

    }

    private fun checkPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            recordAudioRequestCode
        )
    }

    override fun onClick(v: View) {
            speechRecognizer.startListening(speechRecognizerIntent)
            Log.d(tag, "startListening")
    }

    override fun onDestroy() {
        super.onDestroy()
        speechRecognizer.destroy()
    }

    // RecognitionListener

    override fun onReadyForSpeech(params: Bundle?) {
        Log.d(tag, "onReadyForSpeech")
    }

    override fun onBeginningOfSpeech() {
        text.text = "Listening..."
        Log.d(tag, "onBeginningOfSpeech")
    }

    override fun onRmsChanged(rmsdB: Float) {
//        Log.d(tag, "onRmsChanged")
    }

    override fun onBufferReceived(buffer: ByteArray?) {
        Log.d(tag, "onBufferReceived")
    }

    /**
     * Called after the user stops speaking.*/
    override fun onEndOfSpeech() {
        text.text = ""
        Log.d(tag, "onEndOfSpeech")
    }

    override fun onError(error: Int) {
        Log.d(tag, "onError() errorCode : $error")
    }

    override fun onResults(results: Bundle?) {
        val data = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        text.text = data?.get(0) ?: "nothing"
        Log.d(tag, "onResults ${data?.get(0)}")
    }

    override fun onPartialResults(partialResults: Bundle?) {
        Log.d(tag, "onPartialResults")
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
        Log.d(tag, "onEvent")
    }




    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == recordAudioRequestCode && grantResults.isNotEmpty()){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
        }
    }


}
