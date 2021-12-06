package com.aipaygo.kmmproj.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aipaygo.kmmproj.Greeting
import android.widget.TextView
import com.aipaygo.kmmproj.API.APIRequest
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val coffeeAPI = APIRequest()
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Loading..."

        mainScope.launch {
            kotlin.runCatching {
                coffeeAPI.coffeeInfo()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                tv.text = "Error: ${it.localizedMessage}"
            }
        }

    }
}
