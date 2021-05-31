package com.javed.mymessagingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_convo2.*

class ConvoActivity : AppCompatActivity() {

    private var chatAdapter: ChatAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convo2)

        val bundle = intent.extras
        val name = bundle?.getString("abc")
        tvShowName.text = name
    }
}