package com.o7solutions.kmv_college_practise.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.o7solutions.kmv_college_practise.R
import org.w3c.dom.Text



class ChatAdapter(val list: ArrayList<Person>,val onClick: OnItemClickListener): RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat,parent,false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ChatViewHolder,
        position: Int
    ) {

        val item = list[position]

        holder.name.text = item.name
        holder.lastMessage.text = item.lastMessage
        holder.time.text = item.time

        holder.view.setOnClickListener {
            onClick.onClick(position)
        }



    }

    override fun getItemCount(): Int {

        return list.size
    }


    inner class ChatViewHolder(val view: View): RecyclerView.ViewHolder(view){

        val name = view.findViewById<TextView>(R.id.name)
        val lastMessage = view.findViewById<TextView>(R.id.lastMessage)
        val time = view.findViewById<TextView>(R.id.time)


    }


    interface OnItemClickListener {

        fun onClick(position: Int)

    }

}