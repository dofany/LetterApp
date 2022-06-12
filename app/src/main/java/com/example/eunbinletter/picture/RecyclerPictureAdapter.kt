package com.example.eunbinletter.picture

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.eunbinletter.R
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerPictureAdapter(private val items: ArrayList<PictureData>) : RecyclerView.Adapter<RecyclerPictureAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        val listener = View.OnClickListener { it ->
//            Toast.makeText(it.context, "Clicked -> ID : ${item.id}, Name : ${item.name}", Toast.LENGTH_SHORT).show()
            if(item.id == "은빈아"){
                val intent = Intent(holder.itemView?.context, Picture1::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "너무나도"){
                val intent = Intent(holder.itemView?.context, Picture2::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "사랑하는"){
                val intent = Intent(holder.itemView?.context, Picture3::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "내 사랑♥"){
                val intent = Intent(holder.itemView?.context, Picture4::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "하나씩"){
                val intent = Intent(holder.itemView?.context, Picture6::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "열어보면"){
                val intent = Intent(holder.itemView?.context, Picture6::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "우리들의"){
                val intent = Intent(holder.itemView?.context, Picture7::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "추억이"){
                val intent = Intent(holder.itemView?.context, Picture8::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "열릴거야"){
                val intent = Intent(holder.itemView?.context, Picture9::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "우리"){
                val intent = Intent(holder.itemView?.context, Picture10::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "여행도"){
                val intent = Intent(holder.itemView?.context, Picture11::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "자주 다니고"){
                val intent = Intent(holder.itemView?.context, Picture12::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "많이"){
                val intent = Intent(holder.itemView?.context, Picture13::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "놀러 다니자"){
                val intent = Intent(holder.itemView?.context, Picture14::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "그러니까"){
                val intent = Intent(holder.itemView?.context, Picture15::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "나"){
                val intent = Intent(holder.itemView?.context, Picture16::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "차 사주게 해주면"){
                val intent = Intent(holder.itemView?.context, Picture17::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "좋을거같애♥"){
                val intent = Intent(holder.itemView?.context, Picture18::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "그렇게 해줄꺼지??♥"){
                val intent = Intent(holder.itemView?.context, Picture19::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "폴라로이드 사서"){
                val intent = Intent(holder.itemView?.context, Picture20::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            } else if(item.id == "앨범도 만들자"){
                val intent = Intent(holder.itemView?.context, Picture21::class.java)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            }

        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(inflatedView)
    }

    // 각 항목에 필요한 기능을 구현
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(listener: View.OnClickListener, item: PictureData) {
            view.txtUser_id.text = item.id
            view.txtUser_name.text = item.name
            view.setOnClickListener(listener)
        }
    }
}