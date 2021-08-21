package com.example.howtomakerecyclerview

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var addBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //view 설정
        recyclerView = findViewById(R.id.recycler)
        addBtn = findViewById(R.id.addBtn)


        //array설정
        val list : ArrayList<Data> = ArrayList()


        //adapter 설정
        recyclerView.adapter = MainAdapter(list){ data, position ->
            Toast.makeText(this, "아이템이 삭제됨", Toast.LENGTH_SHORT).show()
            list.remove(data)
            recyclerView.adapter!!.notifyItemRemoved(position)
        }


        //버튼을 눌렀을 때 아이템 추가
        addBtn.setOnClickListener {
            val randomInt = Random.nextInt(100).toString()
            Log.d(TAG, "onCreate: random : $randomInt")
            list.add(
                Data("학생", R.drawable.ic_launcher_foreground, randomInt)
            )
            recyclerView.adapter!!.notifyItemInserted(list.size.minus(1))
        }
    }

}