package com.example.howtomakerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.howtomakerecyclerview.databinding.ActivityMainBinding
import com.example.howtomakerecyclerview.databinding.RowItemBinding

class MainAdapter(val data : ArrayList<Data>,  private val onClick: (data : Data, position : Int)-> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    class ViewHolder(val binding: RowItemBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        val holder = ViewHolder(RowItemBinding.bind(v))
        v.setOnClickListener {
            onClick.invoke(data[holder.adapterPosition], holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.data = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }
}