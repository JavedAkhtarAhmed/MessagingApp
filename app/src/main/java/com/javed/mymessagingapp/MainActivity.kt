package com.javed.mymessagingapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ChatAdapterInterface {
    val chatList: ArrayList<ItemChats> = ArrayList();
    private var chatAdapter: ChatAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        chatList.add(ItemChats("Richa", "How are you", "04:32"))
        chatList.add(ItemChats("Vishist", "bhai", "04:32"))
        chatList.add(ItemChats("Tanzil", "lassan kot", "03:22"))
        chatList.add(ItemChats("Nikesh", "Holly Grummond", "03:10"))
        chatList.add(ItemChats("Ajay", "Akon", "03:12"))
        chatList.add(ItemChats("Reshma", "How are you", "04:32"))
        chatList.add(ItemChats("Deepak", "bhai", "04:32"))
        chatList.add(ItemChats("POPZ", "kuch video he hoga", "03:22"))
        chatList.add(ItemChats("Alan", "Holly Grummond", "03:10"))
        chatList.add(ItemChats("Rj", "Akon", "03:12"))


        chatAdapter = ChatAdapter(chatList, this)
        rvChat.adapter = chatAdapter

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {
                Log.d("abcc", s.toString())
                chatAdapter?.filter(s.toString())
            }
        })

    }

    override fun onItemClick(name: String) {
        val intent = Intent(this, ConvoActivity::class.java)
        intent.putExtra("abc", name)
        startActivity(intent)
    }


//    fun nextActivity(){
//        val intent = Intent(this, ConvoActivity::class.java)
//        startActivity(intent)
//
//    }
}