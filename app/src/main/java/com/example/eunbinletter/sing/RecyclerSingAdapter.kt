package com.example.eunbinletter.sing

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.eunbinletter.R
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerSingAdapter(private val items: ArrayList<SingData>) : RecyclerView.Adapter<RecyclerSingAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        val listener = View.OnClickListener { it ->
//            Toast.makeText(it.context, "Clicked -> ID : ${item.id}, Name : ${item.name}", Toast.LENGTH_SHORT).show()
            if(item.id == "발라드"){
                val intent = Intent(holder.itemView?.context, Balade::class.java)
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
        fun bind(listener: View.OnClickListener, item: SingData) {
            view.txtUser_id.text = item.id
            view.txtUser_name.text = item.name
            view.setOnClickListener(listener)
        }
    }
}