package com.javed.mymessagingapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_chat.view.*


class ChatAdapter(var chatList: ArrayList<ItemChats>, private var callback: ChatAdapterInterface) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    val originalList: ArrayList<ItemChats> = chatList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_chat, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = chatList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatList[position])

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemChats) {
            itemView.txt_name.text = item.name
            itemView.txt_time.text = item.time
            itemView.txt_convo.text = item.convo

            itemView.setOnClickListener {
                callback.onItemClick(item.name)
            }
        }
    }

    fun filter(searchedString: String) {
        var listTemp: ArrayList<ItemChats> = arrayListOf()
        originalList.forEach { chat ->
            if (chat.name.contains(searchedString)) {
                Log.d("xyz", "searchedString is $searchedString")
                listTemp.add(chat)
            }
        }

        chatList = listTemp
        notifyDataSetChanged()
    }


//    fun delByPosition(){
//        main.nextActivity()
//
//    }

//    fun updateList(list: ArrayList<Item_chats>) {
//        chatList = list
//        notifyDataSetChanged()
//    }
//    private val textWatcher = object : TextWatcher {
//        override fun afterTextChanged(s: Editable?) {
//        }
//        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//        }
//        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            output.text = s
//            if (start == 12) {
//                Toast.makeText(applicationContext, "Maximum Limit Reached", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
////    }
//    fun delByPosition(position: Int){
//        notesList.removeAt(position)
//        notifyDataSetChanged()
//    }


}

