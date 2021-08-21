package com.example.howtomakerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val data : ArrayList<Data>, private val onClick: (data : Data, position : Int)-> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemText = itemView.findViewById<TextView>(R.id.itemText)
        val rankText = itemView.findViewById<TextView>(R.id.rankText)
        val itemImage = itemView.findViewById<ImageView>(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //ViewHolder 리턴함.

        //일단 item에 넣을 xml을 설정
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)

        //클릭 리스너를 위한 홀더를 미리 변수로 설정
        val holder = ViewHolder(v)

        //클릭했을 때 생성자 매개변수에 있는 함수 매개변수에 데이터를 전달
        v.setOnClickListener {
            onClick.invoke(data[holder.adapterPosition], holder.adapterPosition)
        }
        return holder
    }

    //리스트 데이터를 설정해주는 함수.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rankText.text = data[position].itemRankText
        holder.itemImage.setImageResource(data[position].itemImageView)
        holder.itemText.text = data[position].itemText
    }


    //아이템 크기 리턴.
    override fun getItemCount(): Int = data.size
}